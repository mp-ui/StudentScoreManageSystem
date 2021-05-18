/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 23:35
 */

package com.prince.dao;

import com.prince.entity.Lesson;

import java.util.List;

public interface LessonDao {
    List<Lesson> getAllLessonBySNo(String sNo);
    List<Lesson> getAllLessonBySNoAndCName(String sNo,String cName);
}
