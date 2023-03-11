package com.jim.sprjfx.mapper;

import com.jim.sprjfx.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jim
 * @Description 教师Mapper
 * @createTime 2022年12月07日
 */
@Mapper
public interface TeacherMapper {

    public Teacher getTeacherByUsername(String username);

    int insertTecher(Teacher teacher);
}
