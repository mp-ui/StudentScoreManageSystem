/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 16:08
 */

package com.prince.service.impl;

import com.prince.dao.TeacherMapper;
import com.prince.entity.*;
import com.prince.factory.SpringFactory;
import com.prince.service.CourseService;
import com.prince.service.SCService;
import com.prince.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class TeacherServiceImpl implements TeacherService {
    TeacherMapper teacherMapper;

    @Override
    public long countByExample(TeacherExample example) {
        return teacherMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(TeacherExample example) {
        return teacherMapper.deleteByExample(example);
    }

    public TeacherMapper getTeacherMapper() {
        return teacherMapper;
    }

    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public int deleteByPrimaryKey(String tNo) {
        return teacherMapper.deleteByPrimaryKey(tNo);
    }

    @Override
    public int insert(Teacher record) {
        return teacherMapper.insert(record);
    }

    @Override
    public int insertSelective(Teacher record) {
        return teacherMapper.insertSelective(record);
    }

    @Override
    public List<Teacher> selectByExample(TeacherExample example) {
        return teacherMapper.selectByExample(example);
    }

    @Override
    public Teacher selectByPrimaryKey(String tNo) {
        return teacherMapper.selectByPrimaryKey(tNo);
    }

    @Override
    public int updateByExampleSelective(Teacher record, TeacherExample example) {
        return teacherMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Teacher record, TeacherExample example) {
        return teacherMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Teacher record) {
        return teacherMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Teacher record) {
        return teacherMapper.updateByPrimaryKey(record);
    }

    public int deleteTeacher(Teacher teacher){
        ApplicationContext applicationContext = SpringFactory.getInstance();
        SCService scService = applicationContext.getBean(SCService.class);
        CourseService courseService = applicationContext.getBean(CourseService.class);
        //获取该老师对应的所有课程
        CourseExample courseExample = new CourseExample();
        courseExample.createCriteria().andTNoEqualTo(teacher.gettNo());
        List<Course> courses = courseService.selectByExample(courseExample);
        //删除所有该课程对应的SC
        for (Course course : courses) {
            SCExample scExample = new SCExample();
            scExample.createCriteria().andCNoEqualTo(course.getcNo());
            scService.deleteByExample(scExample);
        }
        //删除课程
        courseService.deleteByExample(courseExample);
        //删除老师
        return deleteByPrimaryKey(teacher.gettNo());
    }
}
