package com.company.project.service.impl;

import com.company.project.dao.TaskGroupMapper;
import com.company.project.model.TaskGroup;
import com.company.project.service.TaskGroupService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2018/06/29.
 */
@Service
@Transactional
public class TaskGroupServiceImpl extends AbstractService<TaskGroup> implements TaskGroupService {
	@Resource
	private TaskGroupMapper taskGroupMapper;

	@Override
	public void deleteByGroupId(String groupId) {
		taskGroupMapper.deleteByPrimaryKey(groupId);
	}

	@Override
	public TaskGroup findByGrouId(String groupId) {
		return taskGroupMapper.selectByPrimaryKey(groupId);
	}

}
