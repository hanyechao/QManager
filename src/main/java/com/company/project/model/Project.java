package com.company.project.model;

import javax.persistence.*;

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "projectName")
    private String projectname;

    @Column(name = "projectDescribe")
    private String projectdescribe;

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
}