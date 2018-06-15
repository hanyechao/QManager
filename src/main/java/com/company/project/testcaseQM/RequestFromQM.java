package com.company.project.testcaseQM;

import com.company.project.testcaseQM.model.TestcaseQM;

public interface RequestFromQM {

	/**
	 * 获取用例执行状态
	 * @return
	 */
	boolean getStatus();
	
	/**
	 * 停止用例
	 * @return
	 */
	boolean stop();

	/**
	 * 执行用例
	 * @param testcaseQM
	 * @return
	 */
	boolean executed(TestcaseQM testcaseQM);
}
