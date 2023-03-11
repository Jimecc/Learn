package com.jim.sprjfx.mapper;

import com.jim.sprjfx.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jim
 * @Description
 * @createTime 2022年12月07日
 */
@Mapper
public interface StudentMapper {

    public Student getStudentByUsername(String username);

    public int insertStudent(Student student);

}
