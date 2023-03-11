package com.jim.sprjfx.service.Impl;

import com.jim.sprjfx.entity.Teacher;
import com.jim.sprjfx.mapper.TeacherMapper;
import com.jim.sprjfx.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jim
 * @Description
 * @createTime 2022年12月07日
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public int login(String username, String password) {
        Teacher teacher = teacherMapper.getTeacherByUsername(username);
        if(teacher == null){
            return 0;
        }
        if(teacher.getPassword().equals(password)){
            return 1;
        }
        return 0;
    }

    @Override
    public int register(Teacher teacher) {
        return teacherMapper.insertTecher(teacher);
    }

    @Override
    public Teacher getTeacherByUsername(String username) {
        return teacherMapper.getTeacherByUsername(username);
    }


}
