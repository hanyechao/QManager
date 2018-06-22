package com.company.project.testcase.timeTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.project.service.TestcaseService;

@Component
public class MTJHmorniterService {
	
	@Autowired
	TestcaseService testcaseService;


//	@Scheduled(cron = "0/5 * * * * ?")
	public void MTJHmorniter() {

		

	}
}
