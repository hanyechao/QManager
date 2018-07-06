package com.company.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/jenkins")
	public String jenkins() {
		return "jenkins";
	}

	@RequestMapping("/JMeterTestResult")
	public String jmeterTestResult() {
		return "JMeterTestResult";
	}
	
	@RequestMapping("/testcaseList")
	public String testcaseList() {
		return "testcaseList";
	}

	@RequestMapping("/mockdata/project")
	public String mockdata() {
		return "mockdataProject";
	}

	@RequestMapping("/mockdata/project/mockdataList")
	public String mockdataList() {
		return "mockdataList";
	}

	@RequestMapping("/apiTools")
	public String apiTools() {
		return "apiTools";
	}
	
	@RequestMapping("/timeTasklist")
	public String timeTasklist() {
		return "timeTasklist";
	}
	
	@RequestMapping("/timetask/detail")
	public String timetaskdetail() {
		return "timeTaskDetail";
	}
	
	@RequestMapping("/other/project")
	public String project() {
		return "project";
	}
	@RequestMapping("/other/timertask/setting")
	public String timertaskSetting() {
		return "timerTaskSetting";
	}
}
