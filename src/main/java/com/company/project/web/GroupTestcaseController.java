package com.company.project.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.cache.EntityCache;
import com.company.project.cache.ICacheManager;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.GroupTestcase;
import com.company.project.model.TaskGroup;
import com.company.project.model.Testcase;
import com.company.project.quartz.QuartzManager;
import com.company.project.quartz.TestcaseJob;
import com.company.project.service.GroupTestcaseService;
import com.company.project.service.TaskGroupService;
import com.company.project.service.TestcaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Condition;

/**
 * Created by CodeGenerator on 2018/06/29.
 */
@RestController
@RequestMapping("/group/testcase")
public class GroupTestcaseController {
	@Resource
	private GroupTestcaseService groupTestcaseService;

	@Autowired
	TaskGroupService taskGroupServcie;

	@Autowired
	QuartzManager quartzManager;

	@Autowired
	ICacheManager iCacheManager;

	@Autowired
	TestcaseService testcaseService;

	@PostMapping("/add")
	public Result add(@RequestParam String testcaseIds, @RequestParam String groupId) {
		if (StringUtils.isAnyBlank(testcaseIds, groupId)) {
			return ResultGenerator.genFailResult("groupId和testcaseId不能为空！");
		}
		String[] splitIds = testcaseIds.split("\\|");
		List<GroupTestcase> groupTestcases = new ArrayList<>();
		// 配置testcaseService查询条件
		Condition condition = new Condition(Testcase.class);
		for (String testcaseId : splitIds) {
			if (StringUtils.isBlank(testcaseId)) {
				continue;
			}
			if (testcaseService.findBy("testcaseid", testcaseId) == null) {
				continue;
			}
			GroupTestcase groupTestcase = new GroupTestcase();
			groupTestcase.setCratetime(new Date());
			groupTestcase.setModifytime(new Date());
			groupTestcase.setTestcaseid(testcaseId);
			// 设置查询testcaseid
			condition.or().orEqualTo("testcaseid", testcaseId);
			groupTestcase.setGroupId(groupId);
			groupTestcases.add(groupTestcase);
		}
		if (groupTestcases.size() == 0) {
			return ResultGenerator.genFailResult("关联用例不能为0！");
		}
		TaskGroup taskGroup1 = taskGroupServcie.findByGrouId(groupId);
		int count = taskGroup1.getCount();
		// 因为初始化时，只会加载isrun=1到缓存中
		if (taskGroup1.getIsrun() == 1 && !iCacheManager.getAllKeys().contains(groupId)) {
			List<Testcase> testcases = testcaseService.findByCondition(condition);
			// 将查询结果put到缓存中
			iCacheManager.putCache(groupId, new EntityCache(testcases, 0, System.currentTimeMillis()));
			quartzManager.addJob(groupId, taskGroup1.getGroupName(), taskGroup1.getGroupId(), taskGroup1.getGroupName(),
					TestcaseJob.class, taskGroup1.getCronExpression(), iCacheManager.getCacheDataByKey(groupId));
		} else if (taskGroup1.getIsrun() == 1 && iCacheManager.getAllKeys().contains(groupId)) {
			if (iCacheManager.isContains(groupId)) {
				Object cacheDataByKey = iCacheManager.getCacheDataByKey(groupId);
				List<Testcase> testcases = (List<Testcase>) cacheDataByKey;
				List<Testcase> testcasesNew = testcaseService.findByCondition(condition);
				testcases.addAll(testcasesNew);
				if (iCacheManager.clearByKey(groupId)) {
					iCacheManager.putCache(groupId, new EntityCache(testcases, 0, System.currentTimeMillis()));
				}

			}
		}
		groupTestcaseService.save(groupTestcases);
		TaskGroup taskGroup = new TaskGroup();
		taskGroup.setGroupId(groupId);
		taskGroup.setCount(count + groupTestcases.size());
		taskGroupServcie.update(taskGroup);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam String testcaseIds, @RequestParam String groupId) {
		if (StringUtils.isAnyBlank(testcaseIds, groupId)) {
			return ResultGenerator.genFailResult("groupId和testcaseId不能为空！");
		}
		String[] splitIds = testcaseIds.split("\\|");
		TaskGroup taskGroup = taskGroupServcie.findByGrouId(groupId);
		int count = 0;
		List<Testcase> testcases = null;
		if (taskGroup.getIsrun() == 1) {
			testcases = (List<Testcase>) iCacheManager.getCacheDataByKey(groupId);
		}
		for (String testcaseId : splitIds) {
			if (StringUtils.isBlank(testcaseId)) {
				continue;
			}
			if (taskGroup.getIsrun() == 1 && testcases != null) {
				Iterator<Testcase> iterator = testcases.iterator();
				while (iterator.hasNext()) {
					if (iterator.next().getTestcaseid().equals(testcaseId)) {
						iterator.remove();
						break;
					}
				}
			}
			GroupTestcase groupTestcase = new GroupTestcase();
			groupTestcase.setGroupId(groupId);
			groupTestcase.setTestcaseid(testcaseId);
			int delete = groupTestcaseService.delete(groupTestcase);

			count += delete;
		}
		if (taskGroup.getIsrun() == 1 && testcases != null) {
			iCacheManager.clearByKey(groupId);
			iCacheManager.putCache(groupId, new EntityCache(testcases, 0, System.currentTimeMillis()));
		}
		TaskGroup taskGroup1 = new TaskGroup();
		taskGroup1.setGroupId(groupId);
		taskGroup1.setCount(taskGroupServcie.findByGrouId(groupId).getCount() - count);
		taskGroupServcie.update(taskGroup1);

		// List<GroupTestcase> groupTestcases = new ArrayList<>();
		// // 配置testcaseService查询条件
		// Condition condition = new Condition(Testcase.class);
		// for (String testcaseId : splitIds) {
		// if (StringUtils.isBlank(testcaseId)) {
		// continue;
		// }
		// GroupTestcase groupTestcase = new GroupTestcase();
		// groupTestcase.setCratetime(new Date());
		// groupTestcase.setModifytime(new Date());
		// groupTestcase.setTestcaseid(testcaseId);
		// // 设置查询testcaseid
		// condition.or().orEqualTo("testcaseid", testcaseId);
		// groupTestcase.setGroupId(groupId);
		// groupTestcases.add(groupTestcase);
		// }
		// TaskGroup taskGroup1 = taskGroupServcie.findByGrouId(groupId);
		// int count = taskGroup1.getCount();
		// // 判断分组关联用例数量，如果为0，对应缓存没有该groupId内容
		// if (taskGroup1.getIsrun() == 1 && count == 0) {
		// List<Testcase> testcases =
		// testcaseService.findByCondition(condition);
		// // 将查询结果put到缓存中
		// iCacheManager.putCache(groupId, new EntityCache(testcases, 0,
		// System.currentTimeMillis()));
		// quartzManager.addJob(groupId, taskGroup1.getGroupName(),
		// taskGroup1.getGroupId(), taskGroup1.getGroupName(),
		// TestcaseJob.class, taskGroup1.getCronExpression(),
		// iCacheManager.getCacheDataByKey(groupId));
		// } else if (taskGroup1.getIsrun() == 1 && count != 0) {
		// if (iCacheManager.isContains(groupId)) {
		// Object cacheDataByKey = iCacheManager.getCacheDataByKey(groupId);
		// List<Testcase> testcases = (List<Testcase>) cacheDataByKey;
		// List<Testcase> testcasesNew =
		// testcaseService.findByCondition(condition);
		// testcases.addAll(testcasesNew);
		// if (iCacheManager.clearByKey(groupId)) {
		// iCacheManager.putCache(groupId, new EntityCache(testcases, 0,
		// System.currentTimeMillis()));
		// }
		//
		// }
		// }
		// groupTestcaseService.save(groupTestcases);

		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/update")
	public Result update(GroupTestcase groupTestcase) {
		groupTestcaseService.update(groupTestcase);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		GroupTestcase groupTestcase = groupTestcaseService.findById(id);
		return ResultGenerator.genSuccessResult(groupTestcase);
	}

	@PostMapping("/list")
	public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<GroupTestcase> list = groupTestcaseService.findAll();
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}
}
