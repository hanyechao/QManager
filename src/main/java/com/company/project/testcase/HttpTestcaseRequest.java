package com.company.project.testcase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.company.project.common.HttpUtil;
import com.company.project.model.Testcase;

@Component
public class HttpTestcaseRequest implements RequestBase {

	private List<Testcase> testcaseRequests;

	@Override
	public void run() {
		if (testcaseRequests == null || testcaseRequests.size() == 0) {
			return;
		}
		String response = null;
		for (Testcase testcaseRequest : testcaseRequests) {
			if (testcaseRequest.getRequesttype() == RequestTypeEnum.POST.code()) {
				try {
					String requestcontent = testcaseRequest.getRequestcontent();
					if (requestcontent.trim().startsWith("{")||requestcontent.trim().endsWith("}")) {
						System.err.println("json");
						response = HttpUtil.doPost(testcaseRequest.getUrl(), requestcontent);
					}else {
						Map<String, String> map = new HashMap<>();
						if (requestcontent.contains("&")) {
							String[] split = requestcontent.split("&");
							for (String string : split) {
								String[] split2 = string.split("=");
								map.put(split2[0], split2[1]);
							}
						}
						
						response = HttpUtil.doPost(testcaseRequest.getUrl(), map);
					}
					
				} catch (Exception e) {
					response = e.getMessage();
					testcaseRequest.setResponse(response);
				}
			} else if (testcaseRequest.getRequesttype() == RequestTypeEnum.GET.code()) {
				response = HttpUtil.doGet(testcaseRequest.getUrl());
			}
			testcaseRequest.setResponse(response);

		}

	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	public List<Testcase> getTestcaseRequests() {
		return testcaseRequests;
	}

	public void setTestcaseRequests(List<Testcase> testcaseRequests) {
		this.testcaseRequests = testcaseRequests;
	}

	public void setTestcaseRequests(Testcase testcase) {
		if (testcaseRequests == null) {
			this.testcaseRequests = Arrays.asList(testcase);
		} else {

			testcaseRequests = null;
			this.testcaseRequests = Arrays.asList(testcase);
		}
	}
}
