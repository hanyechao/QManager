package com.company.project.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.GroupTestcase;
import com.company.project.model.Project;
import com.company.project.model.ProjectForTestcase;
import com.company.project.model.TaskGroup;
import com.company.project.model.Testcase;
import com.company.project.quartz.TaskService;
import com.company.project.quartz.model.GroupToTask;
import com.company.project.service.GroupTestcaseService;
import com.company.project.service.ProjectService;
import com.company.project.service.TaskGroupService;
import com.company.project.service.TestcaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Condition;

/**
 * Created by CodeGenerator on 2018/06/29.
 */
@RestController
@RequestMapping("/task/group")
public class TaskGroupController {
	@Resource
	private TaskGroupService taskGroupService;

	@Autowired
	TaskService taskService;

	@Autowired
	TestcaseService testcaseService;

	@Autowired
	GroupTestcaseService groupTestcaseService;

	@Autowired
	ProjectService projectService;

	@PostMapping("/add")
	public Result add(TaskGroup taskGroup) {
		taskGroup.setGroupId(UUID.randomUUID().toString());
		taskGroup.setCratetime(new Date());
		taskGroup.setModifytime(new Date());
		taskGroupService.save(taskGroup);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam String groupId) {
		if (StringUtils.isBlank(groupId)) {
			return ResultGenerator.genFailResult("groupId is null!");
		} else if (groupTestcaseService.findByGroupId(groupId) > 0) {
			return ResultGenerator.genFailResult("该定时任务分组内有关联用例暂时不能删除！");
		}
		taskGroupService.deleteByGroupId(groupId);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/update")
	public Result update(TaskGroup taskGroup) {
		taskGroupService.update(taskGroup);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam String groupId) {
		List<GroupToTask> groupTestcase = taskService.getGroupTestcase(2);
		for (GroupToTask groupToTask : groupTestcase) {
			if (groupToTask.getGroupID().equals(groupId)) {
				return ResultGenerator.genSuccessResult(groupToTask);
			}
		}
		return ResultGenerator.genSuccessResult("groupId is null!");
	}

	@PostMapping("/list")
	public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<TaskGroup> list = taskGroupService.findAll();
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@PostMapping("/testcaseJoinGroup")
	public Result testcaseJoinGroup(@RequestParam String groupId) {
		List<Testcase> testcases = testcaseService.findAll();
		Condition condition = new Condition(GroupTestcase.class);
		condition.createCriteria().andEqualTo("groupId", groupId);
		List<GroupTestcase> groupTestcases = groupTestcaseService.findByCondition(condition);
		List<String> testcaseIds = new ArrayList<>();
		for (GroupTestcase groupTestcase : groupTestcases) {
			testcaseIds.add(groupTestcase.getTestcaseid());
		}
		List<Testcase> filtered = testcases.stream().filter(testcase -> !testcaseIds.contains(testcase.getTestcaseid()))
				.collect(Collectors.toList());
		List<ProjectForTestcase> projectForTestcases = new ArrayList<>();
		List<Project> projects = projectService.findAll();
		List<Testcase> testcaseOther = new ArrayList<>();
		for (Project project : projects) {
			ProjectForTestcase projectForTestcase = new ProjectForTestcase();
			projectForTestcase.setProjectname(project.getProjectname());
			projectForTestcase.setProjectId(project.getProjectId());
			projectForTestcase.setProjectdescribe(project.getProjectdescribe());
			List<Testcase> testcases2 = new ArrayList<>();
			for (Testcase testcase : filtered) {
				if (StringUtils.equals(project.getProjectId(), testcase.getProjectid())) {
					testcases2.add(testcase);
					continue;
				}

			}
			projectForTestcase.setParams(testcases2);
			projectForTestcases.add(projectForTestcase);
		}
		for (Testcase testcase : filtered) {
			if (testcase.getProjectid().equals("") || testcase.getProjectid().equals("other")) {
				testcaseOther.add(testcase);
			}
		}
		ProjectForTestcase projectForTestcaseOther = new ProjectForTestcase();
		projectForTestcaseOther.setProjectname("其他");
		projectForTestcaseOther.setProjectId("other");
		projectForTestcaseOther.setParams(testcaseOther);
		projectForTestcases.add(projectForTestcaseOther);
		List<ProjectForTestcase> collect = projectForTestcases.stream()
				.filter(projectfortestcase -> projectfortestcase.getParams().size() > 0).collect(Collectors.toList());

		return ResultGenerator.genSuccessResult(collect);
	}

}
