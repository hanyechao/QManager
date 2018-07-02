package com.company.project.quartz.model;

import java.util.List;

import com.company.project.model.Testcase;

import lombok.Data;

@Data
public class GroupToTask {

	String groupName;
	
	String groupID;
	
	String groupDescribe;
	
	int isRun  = 0;
	
	String cronExpression;
	
	List<Testcase> testcases;
	
}
