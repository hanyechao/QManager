package com.company.project.testcase;

public enum RequestTypeEnum {

	POST(0),GET(1);
	
    private final int code;

    RequestTypeEnum(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
	
	
}
