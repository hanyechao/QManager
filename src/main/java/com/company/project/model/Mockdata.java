package com.company.project.model;

import javax.persistence.*;

public class Mockdata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "interfaseName")
    private String interfasename;

    @Column(name = "project_id")
    private Integer projectId;

    private String method;

    private String status;

    @Column(name = "bodyFileName")
    private String bodyfilename;

    private String headers;

    private String content;

    private String comment;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return interfaseName
     */
    public String getInterfasename() {
        return interfasename;
    }

    /**
     * @param interfasename
     */
    public void setInterfasename(String interfasename) {
        this.interfasename = interfasename;
    }

    /**
     * @return project_id
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * @param projectId
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * @return method
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return bodyFileName
     */
    public String getBodyfilename() {
        return bodyfilename;
    }

    /**
     * @param bodyfilename
     */
    public void setBodyfilename(String bodyfilename) {
        this.bodyfilename = bodyfilename;
    }

    /**
     * @return headers
     */
    public String getHeaders() {
        return headers;
    }

    /**
     * @param headers
     */
    public void setHeaders(String headers) {
        this.headers = headers;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}