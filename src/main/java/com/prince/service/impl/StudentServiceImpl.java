/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 16:02
 */

package com.prince.service.impl;

import com.prince.dao.CourseMapper;
import com.prince.dao.StudentMapper;
import com.prince.entity.Course;
import com.prince.entity.CourseExample;
import com.prince.entity.Student;
import com.prince.entity.StudentExample;
import com.prince.service.StudentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class StudentServiceImpl implements StudentService {

    StudentMapper studentMapper;
    @Override
    public long countByExample(StudentExample example) {
        return studentMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(StudentExample example) {
        return studentMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String sNo) {
        return studentMapper.deleteByPrimaryKey(sNo);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public List<Student> selectByExample(StudentExample example) {
        return studentMapper.selectByExample(example);
    }

    @Override
    public Student selectByPrimaryKey(String sNo) {
        return studentMapper.selectByPrimaryKey(sNo);
    }

    @Override
    public int updateByExampleSelective(Student record, StudentExample example) {
        return studentMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Student record, StudentExample example) {
        return studentMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }
}
