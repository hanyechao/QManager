package com.company.project.service;
import com.company.project.model.Project;
import com.company.project.core.Service;


/**
 * Created by CodeGenerator on 2018/07/04.
 */
public interface ProjectService extends Service<Project> {

	/**
	 * 根据groupId删除指定条目
	 * @param groupId
	 * @return
	 */
	public int deleteByGroupId(String projectId);

}
