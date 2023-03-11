package com.jim.sprjfx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jim
 * @Description 教师
 * @createTime 2022年12月07日
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {

    private int id;
    private String name;
    private String username;
    private String password;

    @Override
    public String toString(){
        return "id:"+id+
                "name:"+name+
                "username:"+username+
                "password:"+password;

    }

}
