package com.conpany.project;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WechatTest {
	Logger logger = LoggerFactory.getLogger(WechatTest.class);

	public static void main(String[] args) {
		List<String> strings = null;
		if (strings == null) {
			strings = new ArrayList<>();
			strings.add("aaaa");
		}
		System.err.println(strings.get(0));
		strings.clear();
		System.err.println(strings.get(0));
		
	}

}
