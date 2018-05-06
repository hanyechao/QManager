package com.conpany.project;

import org.junit.Test;

import com.company.project.common.HttpUtil;

public class HttpUtilTest {

	@Test
	public void HttpDoGetTest() throws Exception {
		String doGet = HttpUtil.doPost("http://www.baidu.com", "");
		System.err.println(doGet);
	}
}
