package com.prince.dao;

import com.prince.entity.SC;
import com.prince.entity.SCExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SCMapper {
    long countByExample(SCExample example);

    int deleteByExample(SCExample example);

    int insert(SC record);

    int insertSelective(SC record);

    List<SC> selectByExample(SCExample example);

    int updateByExampleSelective(@Param("record") SC record, @Param("example") SCExample example);

    int updateByExample(@Param("record") SC record, @Param("example") SCExample example);
}