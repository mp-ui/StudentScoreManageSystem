/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 15:27
 */

package com.prince.service.impl;

import com.prince.dao.CourseMapper;
import com.prince.entity.Course;
import com.prince.entity.CourseExample;
import com.prince.entity.SCExample;
import com.prince.factory.SpringFactory;
import com.prince.service.CourseService;
import com.prince.service.SCService;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CourseServiceImpl implements CourseService {
    CourseMapper courseMapper;

    @Override
    public long countByExample(CourseExample example) {
        return courseMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CourseExample example) {
        return courseMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer cNo) {
        return courseMapper.deleteByPrimaryKey(cNo);
    }

    @Override
    public int insert(Course record) {
        return courseMapper.insert(record);
    }

    @Override
    public int insertSelective(Course record) {
        return courseMapper.insertSelective(record);
    }

    @Override
    public List<Course> selectByExample(CourseExample example) {
        return courseMapper.selectByExample(example);
    }

    @Override
    public Course selectByPrimaryKey(Integer cNo) {
        return courseMapper.selectByPrimaryKey(cNo);
    }

    @Override
    public int updateByExampleSelective(Course record, CourseExample example) {
        return courseMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Course record, CourseExample example) {
        return courseMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Course record) {
        return courseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Course record) {
        return courseMapper.updateByPrimaryKey(record);
    }

    public CourseMapper getCourseMapper() {
        return courseMapper;
    }

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public int deleteCourse(int cNo){
        ApplicationContext applicationContext = SpringFactory.getInstance();
        SCService scService = applicationContext.getBean(SCService.class);
        SCExample scExample = new SCExample();
        scExample.createCriteria().andCNoEqualTo(cNo);
        scService.deleteByExample(scExample); //要先删除SC才删除Course
        return deleteByPrimaryKey(cNo);
    }
}
