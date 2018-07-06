package com.company.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "project_id")
    private String projectId;

    @Column(name = "projectName")
    private String projectname;

    @Column(name = "projectDescribe")
    private String projectdescribe;
    
    private Date createtime;

    private Date modifytime;

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
     * @return group_id
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * @param groupId
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * @return projectName
     */
    public String getProjectname() {
        return projectname;
    }

    /**
     * @param projectname
     */
    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    /**
     * @return projectDescribe
     */
    public String getProjectdescribe() {
        return projectdescribe;
    }

    /**
     * @param projectdescribe
     */
    public void setProjectdescribe(String projectdescribe) {
        this.projectdescribe = projectdescribe;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return modifytime
     */
    public Date getModifytime() {
        return modifytime;
    }

    /**
     * @param modifytime
     */
    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }
}