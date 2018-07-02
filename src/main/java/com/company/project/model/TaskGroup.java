package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "task_group")
public class TaskGroup {
    @Id
    @Column(name = "group_id")
    private String groupId;

    private Date cratetime;

    private Date modifytime;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_describe")
    private String groupDescribe;

    @Column(name = "isRun")
    private Byte isrun;

    @Column(name = "cron_expression")
    private String cronExpression;

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
     * @return group_name
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @return group_describe
     */
    public String getGroupDescribe() {
        return groupDescribe;
    }

    /**
     * @param groupDescribe
     */
    public void setGroupDescribe(String groupDescribe) {
        this.groupDescribe = groupDescribe;
    }

    /**
     * @return isRun
     */
    public Byte getIsrun() {
        return isrun;
    }

    /**
     * @param isrun
     */
    public void setIsrun(Byte isrun) {
        this.isrun = isrun;
    }

    /**
     * @return cron_expression
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * @param cronExpression
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
}