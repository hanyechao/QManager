package com.company.project.quartz;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.project.model.Testcase;
import com.company.project.testcaseQM.SendRequestQM;

public class TestcaseJob implements Job {

	@Autowired
	SendRequestQM sendRequestQM;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Object object = arg0.getJobDetail().getJobDataMap().get("data1");
		List<Testcase> testcases = (List<Testcase>) object;
		sendRequestQM.setTestcaseQMs(testcases);
		try {
			sendRequestQM.run();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println(arg0.getJobDetail().getKey().getName());
		for (Testcase testcase : testcases) {
			System.err.println(testcase.getResponse());
		}


	}

}
