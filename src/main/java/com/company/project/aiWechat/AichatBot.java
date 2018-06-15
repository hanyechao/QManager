package com.company.project.aiWechat;

import com.company.project.aiWechat.model.JenkinsMsg;

public interface AichatBot {

	public void startService();
	
	public boolean sendMesage(JenkinsMsg jenkinsMsg);
}
