package com.company.project.quartz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 容器监听器
 * 
 * @author QQ 1535512395
 */
public class QuartzJobListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent arg0) {
		System.err.println("QuartzJobListener 启动了");
		/*** 处理获取数据库的job表，然后遍历循环每个加到job中 ***/
		QuartzManager quartzManager = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext())
				.getBean(QuartzManager.class);

		// 此处就不写获取数据库了，模拟一个集合遍历的数据
		List<Map<String, Object>> listMap = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("jobClass", "com.company.project.quartz");
		map1.put("jobName", "job1");
		map1.put("jobGroupName", "job1");
		map1.put("jobTime", "0/5 * * * * ?");
		listMap.add(map1);

		for (Map<String, Object> map : listMap) {
			try {
				quartzManager.addJob("jobName", "jobGroupName", "triggerName", "riggerGroupName", TestcaseJob.class,
						"0/5 * * * * ?");
				// quartzManager.addJob((Class<? extends
				// Job>)(Class.forName((String)map1.get("jobClass")).newInstance().getClass()),(String)map.get("jobName"),
				// (String)map.get("jobGroupName"),(String)map.get("jobTime"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.err.println("QuartzJobListener 启动了");
	}

	public void contextDestroyed(ServletContextEvent arg0) {
	}

}
