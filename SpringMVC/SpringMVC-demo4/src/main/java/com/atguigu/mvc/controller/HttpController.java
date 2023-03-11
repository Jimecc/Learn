package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jim
 * @Description
 * @createTime 2022年08月09日
 */
@Controller
public class HttpController {

    @RequestMapping(value="/testRequestBody",method = RequestMethod.POST)
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody:\t" + requestBody.toString());
        return "success";
    }

    @RequestMapping(value="/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> request){
        System.out.println("请求头："+request.getHeaders());
        System.out.println("请求体:"+request.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello,Response");
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() throws IOException {
        return "success";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User(1001,"admin","123456",23,"男");
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username,String password ){
        System.out.println(username+"\t"+password);
        return  "hello,Axios";
    }

}
