package com.jim.sprjfx.service;

import com.jim.sprjfx.entity.Teacher;

/**
 * @author Jim
 * @Description
 * @createTime 2022年12月07日
 */
public interface TeacherService {
    int login(String username, String password);
    int register(Teacher teacher);
    Teacher getTeacherByUsername(String username);
}
