package com.conpany.project;

import java.io.File;

import org.junit.Test;

public class OscommandTest {

	@Test
	public void test(){
//		OsCommand osCommand = new OsCommandImpl();
//		String windowsCMD = osCommand.windowsCMD("javac");
//		System.err.println(windowsCMD);
		File file = new File("E:/hanyechao/JMeterTestcase/tmp");
		if (file.isDirectory()) {
			String[] list = file.list();

		}
		
	}
}
