package com.pbody.rest_web.service.impl;

import com.pbody.rest_web.dao.bean.Org;
import com.pbody.rest_web.dao.bean.OrgExample;
import com.pbody.rest_web.dao.dal.OrgMapper;
import com.pbody.rest_web.service.api.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pbody
 * @create 2017-12-13 15:51
 * @description： 组织架构业务实现
 */
@Service("orgService")
public class OrgServiceImpl implements OrgService{

    @Autowired
    private OrgMapper orgMapper;

    public List<Org> getOrgList(){
        OrgExample orgExample=new OrgExample();
//        OrgExample.Criteria criteria = orgExample.createCriteria();
        List<Org> orgList=orgMapper.selectByExample(orgExample);
        return orgList;
    };
}