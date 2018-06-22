package com.company.project.testcaseQM;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.company.project.common.HttpUtil;
import com.company.project.testcaseQM.model.TestcaseQM;

@Component
public class GetRequestFromQM implements RequestFromQM {

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean stop() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean executed(TestcaseQM testcaseQM) {
		if (testcaseQM.getRequesttype() == RequestTypeEnum.GET.code()) {

			try {
				if (StringUtils.isBlank(testcaseQM.getRequestcontent())) {
					String doGet = HttpUtil.doGet(testcaseQM.getUrl());
					testcaseQM.setResponse(doGet);
				} else {
					String doGet = HttpUtil.doGet(testcaseQM.getUrl() + "?" + testcaseQM.getRequestcontent());
					testcaseQM.setResponse(doGet);
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				testcaseQM.setResponse(e.getLocalizedMessage());
			}

		}
		return false;
	}

}
