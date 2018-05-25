package com.company.project.configurer;

import java.io.File;

public interface OsCommandList {

	String JMETER_TESTCASE_PATH = "E:/hanyechao/JMeterTestcase/tmp";

	String WIN_JMETER_COMMAND_REPORT = "E:\\hanyechao\\JMeterTestcase\\jmter.bat";
	// 项目在硬盘上的基础路径
	String PROJECT_PATH = System.getProperty("user.dir");
	String RSOURCES_DIR = OsCommandList.class.getClassLoader().getResource("").getPath();
	String LINUX_WIREMOCK_RUN = "sh " + RSOURCES_DIR + File.separator + "runwiremock.sh";
	String WIN_WIREMOCK_RUN = "java -jar " + Thread.currentThread().getContextClassLoader()
			.getResource("wiremock-1.57-standalone.jar").getPath().substring(1) + " --port 9999 --verbose";
	String WIRE_MOCK_NAME = "wiremock.log";
	String WIN_WIREMOCK_RUN_LOG = "java -jar "
			+ Thread.currentThread().getContextClassLoader().getResource("wiremock-1.57-standalone.jar").getPath()
					.substring(1)
			+ " --port 9999 --verbose >>" + PROJECT_PATH + File.separator + "log" + File.separator + WIRE_MOCK_NAME;
	String MAPPING_PATH = PROJECT_PATH + File.separator + "mappings";

}
