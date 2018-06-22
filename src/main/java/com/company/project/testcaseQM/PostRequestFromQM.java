package com.company.project.testcaseQM;

import java.util.Hashtable;

import javax.servlet.http.HttpUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.company.project.common.HttpUtil;
import com.company.project.common.JSONUtil;
import com.company.project.testcaseQM.model.TestcaseQM;

@Component
public class PostRequestFromQM implements RequestFromQM {

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
		if (testcaseQM.getRequesttype() == RequestTypeEnum.POST.code()) {

			try {
				if (JSONUtil.isJson(testcaseQM.getRequestcontent())
						&& StringUtils.isNotBlank(testcaseQM.getRequestcontent())) {
					String doPost = HttpUtil.doPost(testcaseQM.getUrl(), testcaseQM.getRequestcontent());
					testcaseQM.setResponse(doPost);
				} else {
					Hashtable<String, String[]> parseQueryString = HttpUtils
							.parseQueryString(testcaseQM.getRequestcontent());
					String doPost = HttpUtil.doPost(testcaseQM.getUrl(), parseQueryString);
					testcaseQM.setResponse(doPost);
				}

			} catch (Exception e) {
				e.printStackTrace();
				testcaseQM.setResponse(e.getMessage());
			}

			return true;

		}
		return false;
	}
	

}
