package com.jim.sprjfx.entity;

import lombok.Data;

/**
 * @author Jim
 * @Description 学生与课程中间表
 * @createTime 2022年12月07日
 */

@Data
public class LesStu {
    private int id;
    private int lesid;
    private int stuid;
}
