package com.jim.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Jim
 * @Description
 * @createTime 2022年08月09日
 */

@Controller
public class ScopeController {

    @RequestMapping("/success")
    public String success(){
        return "success";
    }


    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("testScope","hello,ServletAPI");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("testScope","hello,ModelAndView");
        mav.setViewName("success");
        return mav;
    }


    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testScope","hello,Model");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("testScope","hello,Map");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testScope","hello,ModelMap");
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hello,Session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope","hello,application");
        return "success";
    }
}
