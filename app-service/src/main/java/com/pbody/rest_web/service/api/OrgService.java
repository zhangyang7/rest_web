package com.pbody.rest_web.service.api;

import com.github.pagehelper.PageInfo;
import com.pbody.rest_web.dao.bean.Org;

import java.util.List;

/**
 * @author Pbody
 * @create 2017-12-13 15:50
 * @description： 组织架构接口
 */
public interface OrgService {

    /**
     * 获取组织的分页列表
     * @return
     */
    public PageInfo<Org> getOrgList(Org orgForm);

}