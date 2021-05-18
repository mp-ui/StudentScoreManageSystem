/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 15:19
 */

package com.prince.service.impl;

import com.prince.dao.AdminMapper;
import com.prince.entity.Admin;
import com.prince.entity.AdminExample;
import com.prince.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class AdminServiceImpl implements AdminService {
    AdminMapper adminMapper;

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public long countByExample(AdminExample example) {
        return adminMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AdminExample example) {
        return adminMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String aNo) {
        return adminMapper.deleteByPrimaryKey(aNo);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    @Override
    public List<Admin> selectByExample(AdminExample example) {
        return adminMapper.selectByExample(example);
    }

    @Override
    public Admin selectByPrimaryKey(String aNo) {
        return adminMapper.selectByPrimaryKey(aNo);
    }

    @Override
    public int updateByExampleSelective(Admin record, AdminExample example) {
        return adminMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Admin record, AdminExample example) {
        return adminMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }
}
