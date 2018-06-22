package com.company.project.service.impl;

import com.company.project.dao.MockDataNewMapper;
import com.company.project.model.MockDataNew;
import com.company.project.service.MockDataNewService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/06/19.
 */
@Service
@Transactional
public class MockDataNewServiceImpl extends AbstractService<MockDataNew> implements MockDataNewService {
    @Resource
    private MockDataNewMapper mockDataNewMapper;

}
