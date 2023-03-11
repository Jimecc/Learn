package com.jim.sprjfx.service;

import com.jim.sprjfx.entity.Lesson;

import java.util.List;

/**
 * @author Jim
 * @Description
 * @createTime 2022年12月07日
 */
public interface LessonService {

    int insertLesson(Lesson lesson);
    Lesson getLessonByID(int id);
    Lesson getLessonByTecID(int tecid);
    Lesson getLessonByNameAndTecID(Lesson lesson);
    int updateLesson(Lesson lesson);
    List<Lesson> getLessonsByTecID(int tecid);
    List<Lesson> getAllLessons();
    List<Lesson> getLessonsByName(String name);
    Lesson getLessonsByID(int id);
    int deleteByID(int id);

}
