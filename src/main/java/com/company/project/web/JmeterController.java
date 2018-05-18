package com.company.project.web;

import java.io.File;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.common.OsCommand;
import com.company.project.common.OsCommandImpl;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;

@RestController
@RequestMapping("/Jmeter")
public class JmeterController {

	@GetMapping("/testcaseList")
	public Result detail(@RequestParam Integer id) {

		return ResultGenerator.genSuccessResult("");
	}

	@PostMapping("/postJmterResport")
	public Result postJmterResport() {
		HashMap<Object, Object> data = new HashMap<>();
		boolean success = false;
		File file = new File("E:/hanyechao/JMeterTestcase/tmp");
		if (file.isDirectory()) {
			String[] list = file.list();
			OsCommand osCommand = new OsCommandImpl();
			osCommand.windowsCMD("E:\\hanyechao\\JMeterTestcase\\jmter.bat" + " " + list.length);
			data.put("success", success);
		}

		return ResultGenerator.genSuccessResult(data);
	}
}
