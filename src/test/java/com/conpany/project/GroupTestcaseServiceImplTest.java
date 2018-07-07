package com.conpany.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.project.model.GroupTestcase;
import com.company.project.model.TaskGroup;
import com.company.project.model.Testcase;
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

	@Test
	public void findByGroupIdTest() {
		GroupTestcase groupTestcase = new GroupTestcase();
		groupTestcase.setGroupId("fc9a1bdf-2c08-43c1-908d-9a28bca2c4da");
		groupTestcase.setTestcaseid("179b8ffe-924c-45c0-a226-28f7f81ac820");
		int delete = groupTestcaseService.delete(groupTestcase);
		System.err.println(delete);

	}
	
	@Test
	public void testcaseTest(){
		Testcase findBy = testcaseService.findBy("testcaseid", "on");
		System.err.println(findBy);
	}
	
	
	public static void main(String[] args) {

		List<String> asList = new ArrayList<>();
		asList.add("a");
		asList.add("ab");
		asList.add("ac");
		asList.add("ac");
		asList.add(null);
		StringBuffer b = new StringBuffer();
		asList.stream().filter(a -> a != "ac" && a != null).forEach(a -> b.append(a + "|"));
		System.err.println(b);

	}
}
