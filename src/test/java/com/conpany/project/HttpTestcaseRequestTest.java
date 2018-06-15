package com.conpany.project;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.project.model.Testcase;
import com.company.project.service.TestcaseService;
import com.company.project.testcase.HttpTestcaseRequest;
import com.company.project.testcaseQM.SendRequestQM;
import com.company.project.testcaseQM.model.TestcaseQM;

public class HttpTestcaseRequestTest extends Tester {

	@Autowired
	TestcaseService testcaseService;

	@Autowired
	HttpTestcaseRequest httpTestcaseRequest;

	@Autowired
	SendRequestQM sendRequestQM;

	@Test
	public void test() {
		List<Testcase> findAll = testcaseService.findAll();
		httpTestcaseRequest.setTestcaseRequests(findAll);
		System.err.println(httpTestcaseRequest.getTestcaseRequests().get(0).getUrl());
		httpTestcaseRequest.run();
		List<Testcase> testcaseRequests = httpTestcaseRequest.getTestcaseRequests();
		for (Testcase testcase : testcaseRequests) {
			System.err.println(testcase.getResponse());
		}

	}

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
