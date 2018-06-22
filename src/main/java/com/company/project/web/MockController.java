package com.company.project.web;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.core.ResultGenerator;
import com.company.project.model.Project;
import com.company.project.service.ProjectService;

import tk.mybatis.mapper.entity.Condition;

@RestController
@RequestMapping("/mock/{projectId}")
public class MockController {

	@Autowired
	ProjectService projectService;

	@RequestMapping(method = RequestMethod.POST, value = "/{apiName}")
	public Object mockPost(@PathVariable String projectId, @PathVariable String apiName) {
		if (StringUtils.isBlank(projectId) || StringUtils.isBlank(apiName)) {
			return ResultGenerator.genFailResult("match the projectId or apiName is error!");
		}

		Condition condition = new Condition(Project.class);
		String projectName = projectId;
		condition.createCriteria().andEqualTo("projectname", projectId);
		List<Project> projects = projectService.findByCondition(condition);
		if (projects == null || projects.size() == 0) {
			return ResultGenerator.genFailResult("project is null!");
		}
		if (apiName.equals("hanyechao")) {
			return "success:true";
		}

		return ResultGenerator.genSuccessResult();
	}

}
