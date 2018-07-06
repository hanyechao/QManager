package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Project;
import com.company.project.model.Testcase;
import com.company.project.service.ProjectService;
import com.company.project.service.TestcaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Condition;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
* Created by CodeGenerator on 2018/07/04.
*/
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Resource
    private ProjectService projectService;
    
    @Autowired
    TestcaseService testcaseService;

    @PostMapping("/add")
    public Result add(Project project) {
    	if (StringUtils.isBlank(project.getProjectname())) {
			return ResultGenerator.genSuccessResult("projectname is blank!");
		}
    	project.setCreatetime(new Date());
    	project.setModifytime(new Date());
    	project.setProjectId(UUID.randomUUID().toString());
    	project.setProjectdescribe(project.getProjectdescribe());
        projectService.save(project);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String projectId) {
    	Condition condition = new Condition(Testcase.class);
    	condition.and().andEqualTo("projectid", projectId);
    	List<Testcase> testcases = testcaseService.findByCondition(condition);
    	if (testcases.size()>0) {
			return ResultGenerator.genFailResult("该项目下有关联用例无法删除！");
		}
        projectService.deleteByGroupId(projectId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Project project) {
        projectService.update(project);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Project project = projectService.findById(id);
        return ResultGenerator.genSuccessResult(project);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Project> list = projectService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    
    
    @PostMapping("/all")
    public Result all() {
    	List<Project> projects = projectService.findAll();
        return ResultGenerator.genSuccessResult(projects);
    }
}
