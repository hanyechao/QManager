package com.company.project.testcaseQM;

public enum RequestFromQMEnum {

	GetRequestFromQM(RequestTypeEnum.GET.code(), GetRequestFromQM.class, "Get请求"), 
	PostRequestFromQM(RequestTypeEnum.POST.code(), PostRequestFromQM.class, "Post请求");

	private int requesttype;
	private Class<?> className;
	private String describe;

	private RequestFromQMEnum(int requesttype, Class<?> className, String describe) {
		this.requesttype = requesttype;
		this.className = className;
		this.describe = describe;

	}

	// 普通方法
	public static Class<?> getClass(int requesttype) {
		for (RequestFromQMEnum c : RequestFromQMEnum.values()) {
			if (c.getRequesttype() == requesttype) {
				return c.getClassName();
			}
		}
		return null;
	}

	public int getRequesttype() {
		return requesttype;
	}

	public void setRequesttype(int requesttype) {
		this.requesttype = requesttype;
	}

	public Class<?> getClassName() {
		return className;
	}

	public void setClassName(Class<?> className) {
		this.className = className;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

}
