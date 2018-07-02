package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "group_testcase")
public class GroupTestcase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date cratetime;

    private Date modifytime;

    @Column(name = "group_id")
    private String groupId;

    @Column(name = "testcaseId")
    private String testcaseid;

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
     * @return cratetime
     */
    public Date getCratetime() {
        return cratetime;
    }

    /**
     * @param cratetime
     */
    public void setCratetime(Date cratetime) {
        this.cratetime = cratetime;
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

    /**
     * @return group_id
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

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
}