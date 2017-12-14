package com.pbody.rest_web.dao.bean;

import java.util.Date;

public class UserRoleRel {
    private Long id;

    private Long userId;

    private Long roleId;

    private Date createTime;

    private String restraint;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRestraint() {
        return restraint;
    }

    public void setRestraint(String restraint) {
        this.restraint = restraint == null ? null : restraint.trim();
    }
}