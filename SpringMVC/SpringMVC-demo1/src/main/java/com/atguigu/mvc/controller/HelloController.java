package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jim
 * @Description
 * @createTime 2022年08月05日
 */
@Controller
public class HelloController {

    @RequestMapping(value="/")
    public String index() {
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }
}

