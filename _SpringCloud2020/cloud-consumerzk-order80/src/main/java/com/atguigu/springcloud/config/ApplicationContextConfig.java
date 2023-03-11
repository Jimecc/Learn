package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Jim
 * @Description
 * @createTime 2022年08月02日
 */
@Configuration
public class ApplicationContextConfig {


    @Bean
    @LoadBalanced
//    @LoadBalanced //让这个RestTemplate在请求时拥有客户端负载均衡的能力  //将此注解注释掉，使用自己的轮询算法不使用默认的
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

