package com.company.project.testcaseQM;

import com.company.project.model.Testcase;

public interface RequestFromQM {

	/**
	 * 获取用例执行状态
	 * 
	 * @return
	 */
	boolean getStatus();

	/**
	 * 停止用例
	 * 
	 * @return
	 */
	boolean stop();

	/**
	 * 执行用例
	 * 
	 * @param <T>
	 * 
	 * @param testcaseQM
	 * @return
	 */
	<T extends Testcase> boolean executed(T testcaseQM);
}
