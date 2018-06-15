package com.company.project.testcase.timeTask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.company.project.model.Testcase;
import com.company.project.service.TestcaseService;
import com.company.project.testcase.HttpTestcaseRequest;

@Component
public class MTJHmorniterService {
	
	@Autowired
	TestcaseService testcaseService;

	@Autowired
	HttpTestcaseRequest httpTestcaseRequest;

//	@Scheduled(cron = "0/5 * * * * ?")
	public void MTJHmorniter() {
		List<Testcase> findAll = testcaseService.findAll();
		httpTestcaseRequest.setTestcaseRequests(findAll);
		httpTestcaseRequest.run();
		List<Testcase> testcaseRequests = httpTestcaseRequest.getTestcaseRequests();
		for (Testcase testcase : testcaseRequests) {
			System.err.println(testcase.getResponse());
		}

	}
}
