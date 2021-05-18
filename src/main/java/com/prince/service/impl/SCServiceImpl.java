/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 15:30
 */

package com.prince.service.impl;

import com.prince.dao.SCMapper;
import com.prince.entity.SC;
import com.prince.entity.SCExample;
import com.prince.service.SCService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class SCServiceImpl implements SCService {
    SCMapper scMapper;

    @Override
    public long countByExample(SCExample example) {
        return scMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SCExample example) {
        return scMapper.deleteByExample(example);
    }

    @Override
    public int insert(SC record) {
        return scMapper.insert(record);
    }

    @Override
    public int insertSelective(SC record) {
        return scMapper.insert(record);
    }

    @Override
    public List<SC> selectByExample(SCExample example) {
        return scMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(SC record, SCExample example) {
        return scMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SC record, SCExample example) {
        return scMapper.updateByExample(record, example);
    }

    public SCMapper getScMapper() {
        return scMapper;
    }

    public void setScMapper(SCMapper scMapper) {
        this.scMapper = scMapper;
    }
}
