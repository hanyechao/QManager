package com.conpany.project;

import java.lang.reflect.Field;

import com.company.project.model.Testcase;

public class TestClass {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Testcase testcase = new Testcase();
		testcase.setRequesttype(1);
		Field[] fields = testcase.getClass().getDeclaredFields();
		System.err.println(fields.length);
		for (Field field : fields) {
			field.setAccessible(true);
			System.err.println(field.getName()+":"+field.get(testcase));
		}
	}
}
