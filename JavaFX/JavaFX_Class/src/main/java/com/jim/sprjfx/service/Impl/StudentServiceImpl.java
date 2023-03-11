package com.jim.sprjfx.service.Impl;

import com.jim.sprjfx.entity.Student;
import com.jim.sprjfx.mapper.StudentMapper;
import com.jim.sprjfx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jim
 * @Description
 * @createTime 2022年12月07日
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public int login(String username, String password) {
        Student student = studentMapper.getStudentByUsername(username);
        if(null == student){
            return 0;
        }
        if (password.equals(student.getPassword())){
            return 1;
        }
        return 0;
    }

    @Override
    public int register(Student student){
        return studentMapper.insertStudent(student);
    }

    @Override
    public Student getStudentByUsername(String username) {
        return studentMapper.getStudentByUsername(username);
    }
}
