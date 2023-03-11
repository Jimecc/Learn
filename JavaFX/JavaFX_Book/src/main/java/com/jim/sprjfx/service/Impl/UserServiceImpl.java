package com.jim.sprjfx.service.Impl;

import com.jim.sprjfx.entity.User;
import com.jim.sprjfx.mapper.UserMapper;
import com.jim.sprjfx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jim
 * @Description
 * @createTime 2022年12月07日
 */
@Service
public class UserServiceImpl implements UserService {

    // 自动注入userMapper层（Mapper层主要用于读写数据库）
    @Autowired
    private UserMapper userMapper;

    // 使用用户名查找用户， 一般用于登录的校验、注册时候判断用户名是否已经被注册了
    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }


    // 登录功能，传入一个用户名与密码，然后尝试从数据库中查找，找得到再判断密码，找不到直接登录失败，并提示没有此用户
    @Override
    public int Login(String username, String password) {
        // 根据用户名查找此用户
        User user = userMapper.getUserByUsername(username);

        // 找不到，想View层返回 0【用户名未被注册】
        if(user == null){
            return 0;
        }

        // 找到了且密码一致，返回1【登陆成功】
        if(password.equals(user.getPassword())){
            return 1; // 登录成功
        }

        // 其他情况，所有不符合以上情况的情况都属于"其他情况"，比如：密码不一致
        return 0; // 登录是被
    }

    // 注册功能
    @Override
    public int Regist(User user) {
        // 向数据库根据用户名查找，如果查找到了说明该用户名已经被注册了，那么就不能进行注册（因为用户名不可重复）
        if(userMapper.getUserByUsername(user.getUsername())!=null){
            return 2;
        }
        // 直接尝试向数据库中插入数据，并且返回查询结果，0是失败，1是成功
        return userMapper.insertUser(user);
    }

}
