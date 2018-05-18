package com.company.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/JMeterTestResult")
	public String jmeterTestResult() {
		return "JMeterTestResult";
	}
	
	@RequestMapping("/mockdata")
	public String mockdata () {
		return "mockdata";
	}
}
