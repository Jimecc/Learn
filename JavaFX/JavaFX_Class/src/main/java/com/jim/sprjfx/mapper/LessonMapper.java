package com.jim.sprjfx.mapper;

import com.jim.sprjfx.entity.Lesson;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Jim
 * @Description
 * @createTime 2022年12月07日
 */
@Mapper
public interface LessonMapper {

    int insertLesson(Lesson lesson);
    Lesson getLessonByID(int id);
    Lesson getLessonByTecID(int tecid);
    Lesson getLessonByNameAndTecID(Lesson lesson);
    int updateLesson(Lesson lesson);
    List<Lesson> getLessonsByTecID(int tecid);
    List<Lesson> getAllLessons();
    List<Lesson> getLessonsByName(String name);
    int deleteByIdInt(int id);
}
