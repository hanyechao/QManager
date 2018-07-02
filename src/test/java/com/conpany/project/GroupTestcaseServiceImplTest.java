package com.conpany.project;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.project.model.GroupTestcase;
import com.company.project.model.TaskGroup;
import com.company.project.model.Testcase;
import com.company.project.quartz.TestcaseJob;
import com.company.project.quartz.model.GroupToTask;
import com.company.project.service.GroupTestcaseService;
import com.company.project.service.TaskGroupService;
import com.company.project.service.TestcaseService;

import tk.mybatis.mapper.entity.Condition;

public class GroupTestcaseServiceImplTest extends Tester {

	@Autowired
	GroupTestcaseService groupTestcaseService;

	@Autowired
	TaskGroupService taskGroupService;

	@Autowired
	TestcaseService testcaseService;

	@Test
	public void groupTestcaseServiceImplTest() {
		// HashMap<String, List<Testcase>> gtHashMap = new HashMap<>();
		List<GroupToTask> groupToTasks = new ArrayList<>();
		Condition condition = new Condition(TaskGroup.class);
		int isRun = 1;
		condition.and().andEqualTo("isrun", isRun);
		List<TaskGroup> taskGroups = taskGroupService.findByCondition(condition);
		Condition condition1 = new Condition(GroupTestcase.class);
		for (TaskGroup taskGroup : taskGroups) {
			taskGroup.setGroupId(taskGroup.getGroupId());
			taskGroup.setGroupName(taskGroup.getGroupName());
			taskGroup.setGroupDescribe(taskGroup.getGroupDescribe());
			taskGroup.setCronExpression(taskGroup.getCronExpression());
			condition1.or().orEqualTo("groupId", taskGroup.getGroupId());
		}
		List<GroupTestcase> groupTestcases = groupTestcaseService.findByCondition(condition1);
		HashMap<String, List<String>> tcIds = new HashMap<>();
		for (GroupTestcase groupTestcase : groupTestcases) {
			if (!tcIds.keySet().contains(groupTestcase.getGroupId())) {
				List<String> testcaseIds = new ArrayList<>();
				testcaseIds.add(groupTestcase.getTestcaseid());
				tcIds.put(groupTestcase.getGroupId(), testcaseIds);
			} else {
				tcIds.get(groupTestcase.getGroupId()).add(groupTestcase.getTestcaseid());
			}
		}
		Set<Entry<String, List<String>>> entrySet = tcIds.entrySet();
		for (Entry<String, List<String>> entry : entrySet) {
			Condition condition2 = new Condition(Testcase.class);
			for (String testcaseid : entry.getValue()) {
				condition2.or().orEqualTo("testcaseid", testcaseid);
			}
			for (GroupToTask groupToTask : groupToTasks) {
				if (groupToTask.getGroupID().equals(entry.getKey())) {
					groupToTask.setTestcases(testcaseService.findByCondition(condition2));
				}
			}
			// gtHashMap.put(entry.getKey(),
			// testcaseService.findByCondition(condition2));
		}
	}

	public static void main(String[] args) {
		try {
			org.quartz.Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			// 定义一个Trigger
			Trigger trigger = newTrigger().withIdentity("trigger1", "group1") // 定义name/group
					.startNow()// 一旦加入scheduler，立即生效
					.withSchedule(simpleSchedule() // 使用SimpleTrigger
							.withIntervalInSeconds(1) // 每隔一秒执行一次
							.repeatForever()) // 一直执行，奔腾到老不停歇
					.build();

			// 定义一个JobDetail
			JobDetail job = newJob(TestcaseJob.class) // 定义Job类为HelloQuartz类，这是真正的执行逻辑所在
					.withIdentity("job1", "group1") // 定义name/group
					.usingJobData("name", "quartz") // 定义属性
					.build();

			Trigger trigger2 = newTrigger().withIdentity("trigger2", "group2") // 定义name/group
					.startNow()// 一旦加入scheduler，立即生效
					.withSchedule(simpleSchedule() // 使用SimpleTrigger
							.withIntervalInSeconds(3) // 每隔一秒执行一次
							.repeatForever()) // 一直执行，奔腾到老不停歇
					.build();

			// 定义一个JobDetail
			JobDetail job2 = newJob(TestcaseJob.class) // 定义Job类为HelloQuartz类，这是真正的执行逻辑所在
					.withIdentity("job2", "group2") // 定义name/group
					.usingJobData("name", "quartz") // 定义属性
					.build();
			// 加入这个调度
			scheduler.scheduleJob(job, trigger);
			scheduler.scheduleJob(job2, trigger2);

			// 启动之
			scheduler.start();

		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
