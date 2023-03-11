package com.jim.sprjfx.service;

import com.jim.sprjfx.entity.Student;

/**
 * @author Jim
 * @Description
 * @createTime 2022年12月07日
 */
public interface StudentService {
    int login(String username, String password);
    int register(Student student);
    Student getStudentByUsername(String username);

}
