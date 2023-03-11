package com.jim.sprjfx.service.Impl;

import com.jim.sprjfx.entity.Lesson;
import com.jim.sprjfx.mapper.LessonMapper;
import com.jim.sprjfx.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jim
 * @Description
 * @createTime 2022年12月07日
 */
@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    LessonMapper lessonMapper;

    @Override
    public int insertLesson(Lesson lesson) {
        return lessonMapper.insertLesson(lesson);
    }

    @Override
    public Lesson getLessonByID(int id) {
        return lessonMapper.getLessonByID(id);
    }

    @Override
    public Lesson getLessonByTecID(int tecid) {
        return lessonMapper.getLessonByTecID(tecid);
    }

    @Override
    public Lesson getLessonByNameAndTecID(Lesson lesson) {
        return lessonMapper.getLessonByNameAndTecID(lesson);
    }

    @Override
    public int updateLesson(Lesson lesson) {
        return lessonMapper.updateLesson(lesson);
    }

    @Override
    public List<Lesson> getLessonsByTecID(int tecid) {
        return lessonMapper.getLessonsByTecID(tecid);
    }

    @Override
    public List<Lesson> getAllLessons() {
        return lessonMapper.getAllLessons();
    }

    @Override
    public List<Lesson> getLessonsByName(String name) {
        return lessonMapper.getLessonsByName(name);
    }

    @Override
    public Lesson getLessonsByID(int id) {
        return lessonMapper.getLessonByID(id);
    }

    @Override
    public int deleteByID(int id) {
        return lessonMapper.deleteByIdInt(id);
    }



}
