package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Jim
 * @Description
 * @createTime 2022年08月02日
 */
@RestController
public class PaymentController  {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value="/payment/consul")
    public String getPort(){
        return "springcloud with cnosul, serverPort:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}

