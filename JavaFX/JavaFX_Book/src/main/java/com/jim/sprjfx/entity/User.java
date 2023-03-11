package com.jim.sprjfx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jim
 * @Description 用户表
 * @createTime 2022年12月07日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String name; // 名字
    private String username; // 用户名
    private String password; // 密码
    private int status; // 状态
    private int student; // 是否是学生

}
