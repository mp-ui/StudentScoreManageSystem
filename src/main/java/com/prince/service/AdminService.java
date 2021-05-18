/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 12:23
 */

package com.prince.service;

import com.prince.entity.Admin;
import com.prince.entity.AdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(String aNo);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(String aNo);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}
