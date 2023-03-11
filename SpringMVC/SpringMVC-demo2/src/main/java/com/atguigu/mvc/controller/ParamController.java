package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author Jim
 * @Description
 * @createTime 2022年08月06日
 */

@Controller
public class ParamController {


    @RequestMapping("/testServletAPI")
    // 形参位置的request 表示当前请求
    public String testServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        System.out.println(name);
        System.out.println(pass);
        return "test_Param";
    }
    @RequestMapping("/testParam2")
    // 形参位置的request 表示当前请求
    public String testServletAPI2(String username,String password){
        System.out.println(username);
        System.out.println(password);
        return "test_Param";
    }

    @RequestMapping("/testParam3")
    // 形参位置的request 表示当前请求
    public String testServletAPI3(@RequestParam(value = "user_name",defaultValue = "hehe") String username, String password, String[] hobby){
        System.out.println(username);
        System.out.println(password);
        System.out.println(Arrays.toString(hobby));
        return "test_Param";
    }

}
