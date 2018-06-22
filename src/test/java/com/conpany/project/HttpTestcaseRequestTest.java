package com.conpany.project;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.project.service.TestcaseService;
import com.company.project.testcaseQM.SendRequestQM;
import com.company.project.testcaseQM.model.TestcaseQM;

public class HttpTestcaseRequestTest extends Tester {

	@Autowired
	TestcaseService testcaseService;

	@Autowired
	SendRequestQM sendRequestQM;

	@Test
	public void test2() {
		TestcaseQM testcase = new TestcaseQM();
		testcase.setRequesttype(1);
		testcase.setUrl("https://www.baidu.com/");
		sendRequestQM.setTestcaseQM(testcase);
		try {
			sendRequestQM.run();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
