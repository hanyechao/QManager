package com.company.project.testcase.model;

import com.company.project.model.Testcase;

public class TestcaseRequest extends Testcase {

	public TestcaseRequest(String testcaseid, String testcasename, String requestcontent, String url,
			Integer requesttype, String verification) {
		setTestcaseid(testcaseid);
		setTestcasename(testcasename);
		setRequestcontent(requestcontent);
		setUrl(url);
		setRequesttype(requesttype);
		setVerification(verification);
	}

	@Override
	public String toString() {
		return "TestcaseRequest [getTestcaseid()=" + getTestcaseid() + ", getTestcasename()=" + getTestcasename()
				+ ", getRequestcontent()=" + getRequestcontent() + ", getResponse()=" + getResponse() + ", getUrl()="
				+ getUrl() + ", getRequesttype()=" + getRequesttype() + ", getVerification()=" + getVerification()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
