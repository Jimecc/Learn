package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jim
 * @Description
 * @createTime 2022年08月05日
 */

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
