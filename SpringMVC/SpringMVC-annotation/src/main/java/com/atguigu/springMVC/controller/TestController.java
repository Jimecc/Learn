package com.atguigu.springMVC.controller;

/**
 * @author Jim
 * @Description
 * @createTime 2022年08月11日
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
