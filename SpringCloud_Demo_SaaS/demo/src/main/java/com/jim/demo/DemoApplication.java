package com.jim.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

public class DemoApplication {


    public static void main(String[] args) {
//        Demo demo1 = new Demo();
//        Demo demo2 = new Demo();
//
//        JavaInterface javaInterface = new JavaInterfaceImpl();
//        javaInterface.DemoDefault();

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"jim");
        map.put(2,"hsk");
        System.out.println(map.get(1));
        System.out.println(map.get(3));
    }

}
