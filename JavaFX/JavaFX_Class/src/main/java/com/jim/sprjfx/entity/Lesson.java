package com.jim.sprjfx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jim
 * @Description
 * @createTime 2022年12月07日
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lesson {

    private int id;
    private String name;
    private int num;
    private int rem;
    private int tecid;

    @Override
    public String toString() {
        return    id +
                " \t课程名称:" + name +
                " \t招生数量:" + num +
                " \t剩余数量:" + rem +
                " \t教师ID:" + tecid ;
    }
}
