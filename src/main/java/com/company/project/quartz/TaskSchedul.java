package com.company.project.quartz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.project.cache.EntityCache;
import com.company.project.cache.ICacheManager;
import com.company.project.quartz.model.GroupToTask;

@Configuration
public class TaskSchedul {

	@Autowired
	TaskService taskService;

	@Autowired
	QuartzManager quartzManager;

	@Autowired
	ICacheManager iCacheManager;

	@Bean
	public boolean settingTaskService() {
		List<GroupToTask> groupToTasks = taskService.getGroupTestcase(1);
		// 初始化数据同时写入缓存，过滤掉为空的用例
		groupToTasks.stream()
				.filter(groupToTask -> groupToTask.getTestcases() != null && !groupToTask.getTestcases().isEmpty())
				.forEach(groupToTask -> iCacheManager.putCache(groupToTask.getGroupID(),
						new EntityCache(groupToTask.getTestcases(), 0, System.currentTimeMillis())));

		for (GroupToTask groupToTask : groupToTasks) {
			// isRun=1的分组内，测试用例数量小于等于0，不添加到定时任务的job里
			if (groupToTask.getTestcases() == null || groupToTask.getTestcases().size() < 1) {
				continue;
			}
			quartzManager.addJob(groupToTask.getGroupID(), groupToTask.getGroupName(), groupToTask.getGroupID(),
					groupToTask.getGroupName(), TestcaseJob.class, groupToTask.getCronExpression(),
					iCacheManager.getCacheDataByKey(groupToTask.getGroupID()));
		}

		return true;
	}

}
