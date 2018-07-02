package com.company.project.quartz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.project.quartz.model.GroupToTask;

@Configuration
public class TaskSchedul {

	@Autowired
	TaskService taskService;

	@Autowired
	QuartzManager quartzManager;

	@Bean
	public boolean settingTaskService() {
		List<GroupToTask> groupTestcase = taskService.getGroupTestcase();
		for (GroupToTask groupToTask : groupTestcase) {
			quartzManager.addJob(groupToTask.getGroupID(), groupToTask.getGroupName(), groupToTask.getGroupID(),
					groupToTask.getGroupName(), TestcaseJob.class, groupToTask.getCronExpression(),
					groupToTask.getTestcases());
		}

		return true;
	}

}
