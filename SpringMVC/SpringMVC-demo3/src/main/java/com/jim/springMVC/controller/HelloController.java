package com.jim.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jim
 * @Description
 * @createTime 2022年08月08日
 */
@Controller
public class HelloController {

//    @RequestMapping(value="/")
//    public String index(){
//        return "index";
//    }

    @RequestMapping("/test_view")
    public String test_view(){
        return "test_view";
    }

    @RequestMapping("/test_rest")
    public String test_rest(){
        return "test_rest";
    }
}
