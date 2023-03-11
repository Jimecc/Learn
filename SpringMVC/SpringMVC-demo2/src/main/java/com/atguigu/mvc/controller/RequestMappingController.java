package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Jim
 * @Description
 * @createTime 2022年08月05日
 */
@Controller
@RequestMapping("/hello")
public class RequestMappingController {
    @RequestMapping("/success")
    public String testRequestController(){
        return "success";
    }

    @RequestMapping(value={"/test","/post"},method = {RequestMethod.POST,RequestMethod.GET})
    public String success(){
        return "success";
    }

    @GetMapping("/testGetMapping")
    public String testGetMapping(){
        return "success";
    }
    @GetMapping(value = "/testParams",params = {"username","password"})
    public String testParams(){
        return "success";
    }
    @GetMapping(value = "/testHeaders",headers = {"Host=localhost:8081"})
    public String testHeaders(){
        return "success";
    }

    @RequestMapping("/testAnt")
    public String testAnt(){
        return "success";
    }
    @RequestMapping("/a?a/testAnt")
    public String testAnt2(){
        return "success";
    }

    @RequestMapping("/**/testXX")
    public String testAnt3(){
        return "xx";
    }
//    @GetMapping("/a*a/testAnt")
//    public String testAnt4GetMapping(){
//        return "success";
//    }

    @RequestMapping("/{id}/testPath")
    public String testPathVariable(@PathVariable Integer id){
        System.out.println("id:"+id);
        return "pathVariable";
    }

    @RequestMapping("/param")
    public String testParam(){
        return "test_Param";
    }

}
