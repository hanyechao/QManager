package com.company.project.service.impl;

import com.company.project.dao.TestcaseMapper;
import com.company.project.model.Testcase;
import com.company.project.service.TestcaseService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/06/12.
 */
@Service
@Transactional
public class TestcaseServiceImpl extends AbstractService<Testcase> implements TestcaseService {
    @Resource
    private TestcaseMapper testcaseMapper;

	@Override
	public void deleteTestcaseid(String testcaseid) {
		testcaseMapper.deleteByPrimaryKey(testcaseid);
		
	}

}
