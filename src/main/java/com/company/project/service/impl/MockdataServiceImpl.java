package com.company.project.service.impl;

import com.company.project.dao.MockdataMapper;
import com.company.project.model.Mockdata;
import com.company.project.service.MockdataService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/05/25.
 */
@Service
@Transactional
public class MockdataServiceImpl extends AbstractService<Mockdata> implements MockdataService {
    @Resource
    private MockdataMapper mockdataMapper;

}
