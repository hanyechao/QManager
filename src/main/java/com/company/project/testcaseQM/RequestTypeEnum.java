package com.company.project.testcaseQM;

public enum RequestTypeEnum {

	POST(0),GET(1);
	
    private final int code;
    
	private RequestTypeEnum(int code) {
		this.code = code;
	}
	
    public int code() {
        return code;
    }
	
}
