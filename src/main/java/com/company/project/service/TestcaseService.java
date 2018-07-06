package com.company.project.service;
import com.company.project.core.Service;
import com.company.project.model.Testcase;


/**
 * Created by CodeGenerator on 2018/06/12.
 */
public interface TestcaseService extends Service<Testcase> {

	void deleteTestcaseid(String testcaseid);
}
