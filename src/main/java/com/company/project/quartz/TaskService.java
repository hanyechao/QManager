package com.company.project.quartz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.project.model.GroupTestcase;
import com.company.project.model.TaskGroup;
import com.company.project.model.Testcase;
import com.company.project.quartz.model.GroupToTask;
import com.company.project.service.GroupTestcaseService;
import com.company.project.service.TaskGroupService;
import com.company.project.service.TestcaseService;

import tk.mybatis.mapper.entity.Condition;

@Component
public class TaskService {

	@Autowired
	GroupTestcaseService groupTestcaseService;

	@Autowired
	TaskGroupService taskGroupService;

	@Autowired
	TestcaseService testcaseService;

	protected List<GroupToTask> getGroupTestcase() {
		// HashMap<String, List<Testcase>> gtHashMap = new HashMap<>();
		List<GroupToTask> groupToTasks = new ArrayList<>();
		Condition condition = new Condition(TaskGroup.class);
		int isRun = 1;
		condition.and().andEqualTo("isrun", isRun);
		List<TaskGroup> taskGroups = taskGroupService.findByCondition(condition);
		Condition condition1 = new Condition(GroupTestcase.class);
		for (TaskGroup taskGroup : taskGroups) {
			GroupToTask groupToTask = new GroupToTask();
			groupToTask.setGroupID(taskGroup.getGroupId());
			groupToTask.setGroupName(taskGroup.getGroupName());
			groupToTask.setGroupDescribe(taskGroup.getGroupDescribe());
			groupToTask.setCronExpression(taskGroup.getCronExpression());
			groupToTasks.add(groupToTask);
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
		return groupToTasks;
	}
}
