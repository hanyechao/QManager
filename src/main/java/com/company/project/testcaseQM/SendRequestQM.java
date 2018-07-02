package com.company.project.testcaseQM;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.omg.CORBA.Object;
import org.springframework.stereotype.Component;

import com.alibaba.druid.sql.ast.statement.SQLIfStatement.ElseIf;
import com.company.project.model.Testcase;
import com.company.project.testcaseQM.model.TestcaseQM;

@Component
public class SendRequestQM {

	private List<? extends Testcase> testcaseQMs;

	/**
	 * 执行用例目前暫定順序執行，後期慢慢調整並發模式執行
	 * 
	 * @param requestFromQM
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void run() throws InstantiationException, IllegalAccessException {
		if (testcaseQMs == null || testcaseQMs.size() == 0) {
			return;
		}
		RequestFromQMEnum[] values = RequestFromQMEnum.values();
		Map<RequestFromQMEnum, RequestFromQM> map = new HashMap<>();
		for (RequestFromQMEnum requestFromQMEnum : values) {
			RequestFromQM requestFromQM = (RequestFromQM) RequestFromQMEnum.getClass(requestFromQMEnum.getRequesttype())
					.newInstance();
			map.put(requestFromQMEnum, requestFromQM);
		}
		Set<Entry<RequestFromQMEnum, RequestFromQM>> entrySet = map.entrySet();
		for (Testcase testcaseQM : testcaseQMs) {
			for (Entry<RequestFromQMEnum, RequestFromQM> entry : entrySet) {
				if (entry.getKey().getRequesttype() == testcaseQM.getRequesttype()) {
					entry.getValue().executed(testcaseQM);
				}
			}

			// RequestFromQM requestFromQM = (RequestFromQM)
			// RequestFromQMEnum.getClass(testcaseQM.getRequesttype())
			// .newInstance();
			// requestFromQM.executed(testcaseQM);
		}

	}

	public List<TestcaseQM> getTestcaseQMs() {
		return (List<TestcaseQM>) testcaseQMs;
	}

	public void setTestcaseQMs(List<? extends Testcase> testcaseQMs) {
		this.testcaseQMs = testcaseQMs;
	}

	public void setTestcaseQM(TestcaseQM testcaseQM) {
		this.testcaseQMs = Arrays.asList(testcaseQM);
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		RequestFromQMEnum[] values = RequestFromQMEnum.values();
		Map<RequestFromQMEnum, RequestFromQM> map = new HashMap<>();
		for (RequestFromQMEnum requestFromQMEnum : values) {
			RequestFromQM requestFromQM = (RequestFromQM) RequestFromQMEnum.getClass(requestFromQMEnum.getRequesttype())
					.newInstance();
			map.put(requestFromQMEnum, requestFromQM);
		}
	}
}
