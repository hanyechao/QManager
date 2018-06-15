package com.company.project.aiWechat.model;

public class JenkinsMsg {

	private String userName;
	
	private String jobId;
	
	private ErrorMsg errorMsg;
	
	private String Url;
	
	public class ErrorMsg{
		private String title;
		private String content;
		
		@SuppressWarnings("unused")
		public String getTitle() {
			return title;
		}
		@SuppressWarnings("unused")
		public void setTitle(String title) {
			this.title = title;
		}
		@SuppressWarnings("unused")
		public String getContent() {
			return content;
		}
		@SuppressWarnings("unused")
		public void setContent(String content) {
			this.content = content;
		}
	}

	public ErrorMsg builderEMG(){
		return new ErrorMsg();
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public ErrorMsg getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(ErrorMsg errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
