package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

public class Testcase {
    @Id
    private String uuid;

    private Date createtime;

    private Date modifytime;

    @Column(name = "createUser")
    private String createuser;

    @Column(name = "URL")
    private String url;

    private String group;

    private String request;

    private String response;

    /**
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    /**
     * @return createUser
     */
    public String getCreateuser() {
        return createuser;
    }

    /**
     * @param createuser
     */
    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    /**
     * @return URL
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
     * @return group
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * @return request
     */
    public String getRequest() {
        return request;
    }

    /**
     * @param request
     */
    public void setRequest(String request) {
        this.request = request;
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
}