package com.pbody.rest_web.dao.dal;

import com.pbody.rest_web.dao.bean.Org;
import com.pbody.rest_web.dao.bean.OrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgMapper {
    long countByExample(OrgExample example);

    int deleteByExample(OrgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Org record);

    int insertSelective(Org record);

    List<Org> selectByExample(OrgExample example);

    Org selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Org record, @Param("example") OrgExample example);

    int updateByExample(@Param("record") Org record, @Param("example") OrgExample example);

    int updateByPrimaryKeySelective(Org record);

    int updateByPrimaryKey(Org record);
}