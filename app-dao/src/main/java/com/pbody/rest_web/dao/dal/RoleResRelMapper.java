package com.pbody.rest_web.dao.dal;

import com.pbody.rest_web.dao.bean.RoleResRel;
import com.pbody.rest_web.dao.bean.RoleResRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleResRelMapper {
    long countByExample(RoleResRelExample example);

    int deleteByExample(RoleResRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoleResRel record);

    int insertSelective(RoleResRel record);

    List<RoleResRel> selectByExample(RoleResRelExample example);

    RoleResRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RoleResRel record, @Param("example") RoleResRelExample example);

    int updateByExample(@Param("record") RoleResRel record, @Param("example") RoleResRelExample example);

    int updateByPrimaryKeySelective(RoleResRel record);

    int updateByPrimaryKey(RoleResRel record);
}