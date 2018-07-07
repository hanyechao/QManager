package com.company.project.service.impl;

import com.company.project.dao.GroupTestcaseMapper;
import com.company.project.model.GroupTestcase;
import com.company.project.service.GroupTestcaseService;

import tk.mybatis.mapper.entity.Condition;

import com.company.project.core.AbstractService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2018/06/29.
 */
@Service
@Transactional
public class GroupTestcaseServiceImpl extends AbstractService<GroupTestcase> implements GroupTestcaseService {
	@Resource
	private GroupTestcaseMapper groupTestcaseMapper;

	@Override
	public int findByGroupId(String groupId) {
		GroupTestcase groupTestcase = new GroupTestcase();
		groupTestcase.setGroupId(groupId);
		return groupTestcaseMapper.selectCount(groupTestcase);
	}

	@Override
	public int delete(GroupTestcase groupTestcase) {
		return groupTestcaseMapper.delete(groupTestcase);

	}

}
