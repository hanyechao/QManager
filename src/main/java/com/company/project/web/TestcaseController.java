package com.company.project.web;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.swing.Spring;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.GroupTestcase;
import com.company.project.model.Testcase;
import com.company.project.service.GroupTestcaseService;
import com.company.project.service.TestcaseService;
import com.company.project.testcaseQM.SendRequestQM;
import com.company.project.testcaseQM.model.TestcaseQM;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;

import tk.mybatis.mapper.entity.Condition;

/**
 * Created by CodeGenerator on 2018/06/12.
 */
@RestController
@RequestMapping("/testcase")
public class TestcaseController {
	@Resource
	private TestcaseService testcaseService;

	@Autowired
	SendRequestQM sendRequestQM;

	@Autowired
	GroupTestcaseService groupTestcaseService;

	@PostMapping("/post")
	public Result post(TestcaseQM testcaseQM) {
		if (testcaseQM.getRequesttype() == null
				|| testcaseQM.getRequesttype() != 0 && testcaseQM.getRequesttype() != 1) {
			return ResultGenerator.genFailResult("暂不支持POST和GET以外的类型！");
		} else {
			sendRequestQM.setTestcaseQM(testcaseQM);
			try {
				sendRequestQM.run();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
				testcaseQM.setResponse(e.getMessage());
			}
		}

		return ResultGenerator.genSuccessResult(testcaseQM.getResponse());
	}

	@PostMapping("/add")
	public Result add(Testcase testcase) {
		if (testcase.getRequesttype().equals("")) {
			return ResultGenerator.genFailResult("请求类型不能为空！");
		}
		if (testcase.getUrl().equals("")) {
			return ResultGenerator.genFailResult("URL不能为空！");
		}
		String uuid = UUID.randomUUID().toString();
		testcase.setTestcaseid(uuid);
		if (StringUtils.isBlank(testcase.getProjectid())) {
			testcase.setProjectid("other");
		}
		testcaseService.save(testcase);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam String testcaseid) {
		Condition condition = new Condition(GroupTestcase.class);
		condition.createCriteria().andEqualTo("testcaseid", testcaseid);
		List<GroupTestcase> findByCondition = groupTestcaseService.findByCondition(condition);
		if (findByCondition.size() > 0) {
			return ResultGenerator.genFailResult("定时任务分组内已关联相关用例，请取消关联后再删除！");
		}
		testcaseService.deleteTestcaseid(testcaseid);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/update")
	public Result update(Testcase testcase) {
		testcaseService.update(testcase);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		Testcase testcase = testcaseService.findById(id);
		return ResultGenerator.genSuccessResult(testcase);
	}

	@PostMapping("/list")
	public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<Testcase> list = testcaseService.findAll();
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}
}
