package com.company.project.aiWechat;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.company.project.aiWechat.model.JenkinsMsg;

import io.github.biezhi.wechat.WeChatBot;
import io.github.biezhi.wechat.api.constant.Config;
import io.github.biezhi.wechat.utils.DateUtils;

public class WechatService extends WeChatBot{
	Logger logger = LoggerFactory.getLogger(WechatService.class);
	private List<JenkinsMsg> jenkinsMsgs = null;
	private static WechatService wechatService = new WechatService(Config.me().autoLogin(true).showTerminal(false));
	static {
		wechatService.start();
	}


	public WechatService(Config config) {
		super(config);	
	}
	
	@Override
	protected void other() {
        while (true) {
        	if (jenkinsMsgs!=null && jenkinsMsgs.size()!=0) {
				if (getWechatService()!=null) {
					getWechatService().sendMsgToFileHelper(jenkinsMsgs.get(jenkinsMsgs.size()-1).getUserName());
				}
			}
            DateUtils.sleep(100);
        }
	}

	public List<JenkinsMsg> getJenkinsMsgs() {
		return jenkinsMsgs;
	}

	public void setJenkinsMsgs(List<JenkinsMsg> jenkinsMsgs) {
		this.jenkinsMsgs = jenkinsMsgs;
	}

	public static WechatService getWechatService() {
		return wechatService;
	}
	

}
