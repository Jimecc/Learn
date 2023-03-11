package com.jim.sprjfx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jim
 * @Description 学生类型
 * @createTime 2022年12月07日
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    private int id;
    private String name;
    private String username;
    private String password;
    private String clas; //
}
