package com.company.project.service.impl;

import com.company.project.dao.ProjectMapper;
import com.company.project.model.Project;
import com.company.project.service.ProjectService;

import tk.mybatis.mapper.entity.Condition;

import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/07/04.
 */
@Service
@Transactional
public class ProjectServiceImpl extends AbstractService<Project> implements ProjectService {
    @Resource
    private ProjectMapper projectMapper;

	@Override
	public int deleteByGroupId(String projectId) {
		Condition condition = new Condition(Project.class);
		condition.createCriteria().andEqualTo("projectId", projectId);
		return projectMapper.deleteByCondition(condition);
	}

}
