package com.company.project.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.aiWechat.WechatService;
import com.company.project.aiWechat.model.JenkinsMsg;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;

@RestController
@RequestMapping("/AiWechat")
public class AiWechatController {

	List<JenkinsMsg> jenkinsMsgs;

	@GetMapping("/sendMsg")
	public Result sendMsg(@RequestParam String message) {

		jenkinsMsgs = new ArrayList<>();
		JenkinsMsg jenkinsMsg = new JenkinsMsg();
		jenkinsMsg.setUserName(message);
		jenkinsMsgs.add(jenkinsMsg);
		WechatService.getWechatService().setJenkinsMsgs(jenkinsMsgs);
		return ResultGenerator.genSuccessResult();
	}


}
