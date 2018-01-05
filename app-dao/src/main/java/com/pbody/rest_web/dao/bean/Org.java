package com.pbody.rest_web.dao.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * @author Pbody
 * @create 2018年1月5日16:00:10
 * @description： 组织信息类
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Org extends BaseBean{
    private Long id;

    private String orgid;

    private String displayname;

    private String initials;

    private String description;

    private String status;

    private String parentorgid;

    private String orgtype;

    private String orglevel;

    private String displayorder;

    private String vicemanager;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh", timezone = "GMT+8")
    private Date createtime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh", timezone = "GMT+8")
    private Date lastupdatetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname == null ? null : displayname.trim();
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials == null ? null : initials.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getParentorgid() {
        return parentorgid;
    }

    public void setParentorgid(String parentorgid) {
        this.parentorgid = parentorgid == null ? null : parentorgid.trim();
    }

    public String getOrgtype() {
        return orgtype;
    }

    public void setOrgtype(String orgtype) {
        this.orgtype = orgtype == null ? null : orgtype.trim();
    }

    public String getOrglevel() {
        return orglevel;
    }

    public void setOrglevel(String orglevel) {
        this.orglevel = orglevel == null ? null : orglevel.trim();
    }

    public String getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(String displayorder) {
        this.displayorder = displayorder == null ? null : displayorder.trim();
    }

    public String getVicemanager() {
        return vicemanager;
    }

    public void setVicemanager(String vicemanager) {
        this.vicemanager = vicemanager == null ? null : vicemanager.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }
}