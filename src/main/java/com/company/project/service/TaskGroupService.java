package com.company.project.service;

import com.company.project.model.TaskGroup;
import com.company.project.core.Service;

/**
 * Created by CodeGenerator on 2018/06/29.
 */
public interface TaskGroupService extends Service<TaskGroup> {

	public void deleteByGroupId(String groupId);

	public TaskGroup findByGrouId(String groupId);

}
