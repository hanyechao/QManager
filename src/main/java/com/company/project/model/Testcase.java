package com.company.project.model;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

public class Testcase {
    @Id
    @Column(name = "testcaseId")
    private String testcaseid;

    @Column(name = "testcaseName")
    private String testcasename;

    @Column(name = "requestContent")
    private String requestcontent;

    private String response;

    private String url;

    @Column(name = "requestType")
    private Integer requesttype;

    private String verification;
    
    @Column(name = "projectId")
    @Getter
    @Setter
    private String projectid;

    /**
     * @return testcaseId
     */
    public String getTestcaseid() {
        return testcaseid;
    }

    /**
     * @param testcaseid
     */
    public void setTestcaseid(String testcaseid) {
        this.testcaseid = testcaseid;
    }

    /**
     * @return testcaseName
     */
    public String getTestcasename() {
        return testcasename;
    }

    /**
     * @param testcasename
     */
    public void setTestcasename(String testcasename) {
        this.testcasename = testcasename;
    }

    /**
     * @return requestContent
     */
    public String getRequestcontent() {
        return requestcontent;
    }

    /**
     * @param requestcontent
     */
    public void setRequestcontent(String requestcontent) {
        this.requestcontent = requestcontent;
    }

    /**
     * @return response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return requestType
     */
    public Integer getRequesttype() {
        return requesttype;
    }

    /**
     * @param requesttype
     */
    public void setRequesttype(Integer requesttype) {
        this.requesttype = requesttype;
    }

    /**
     * @return verification
     */
    public String getVerification() {
        return verification;
    }

    /**
     * @param verification
     */
    public void setVerification(String verification) {
        this.verification = verification;
    }
}