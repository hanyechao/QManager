package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.GroupTestcase;

import tk.mybatis.mapper.entity.Condition;

/**
 * Created by CodeGenerator on 2018/06/29.
 */
public interface GroupTestcaseService extends Service<GroupTestcase> {

	int findByGroupId(String groupId);

	int delete(GroupTestcase groupTestcase);

}
