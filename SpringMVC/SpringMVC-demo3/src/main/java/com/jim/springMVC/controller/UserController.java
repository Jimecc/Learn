package com.jim.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jim
 * @Description
 * @createTime 2022年08月09日
 */
@Controller
public class UserController {

    /**
     * 使用 REStFul 模拟用户操作
     * /user GET 查询所有用户信息
     * /user GET 根据用户 id 查询用户信息
     * /user POST 添加用户信息
     * /user DELETE 删除用户信息
     * /user PUT 更新用户信息
     */

    @GetMapping("/user")
    public String getALlUser(){
        System.out.println("查询所有用户信息");
        return "success";
    }


    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("根据 ID 查询用户信息，ID："+id);
        return "success";
    }

    @PostMapping("/user")
    public String insertUser(String username,String password){
        System.out.println("添加用户信息，\n用户名："+username+"\n密码："+password);
        return "success";
    }

    @PutMapping("/user")
    public String updateUser(String username,String password){
        System.out.println("更新用户信息，\n用户名："+username+"\n密码："+password);
        return "success";
    }
}
