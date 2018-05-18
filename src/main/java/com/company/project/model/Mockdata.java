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

    private String response;

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