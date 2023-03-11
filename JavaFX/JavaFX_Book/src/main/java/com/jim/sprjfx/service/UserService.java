package com.jim.sprjfx.service;

import com.jim.sprjfx.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jim
 * @Description
 * @createTime 2022年12月07日
 */
public interface UserService {

    // 向数据库端操作
    public User getUserByUsername(String username);

    // 与用户交互操作
    public int Login(String username,String password);

    public int Regist(User user);

}
