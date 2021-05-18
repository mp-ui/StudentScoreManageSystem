package com.prince.service;

import com.prince.entity.SC;
import com.prince.entity.SCExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SCService {
    long countByExample(SCExample example);

    int deleteByExample(SCExample example);

    int insert(SC record);

    int insertSelective(SC record);

    List<SC> selectByExample(SCExample example);

    int updateByExampleSelective(@Param("record") SC record, @Param("example") SCExample example);

    int updateByExample(@Param("record") SC record, @Param("example") SCExample example);
}