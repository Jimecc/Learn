package com.atguigu.springcloud;

/**
 * @author Jim
 * @Description
 * @createTime 2022年08月02日
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Jim
 * @Description 启动类
 * @createTime 2022年08月02日
 */
@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class PaymentMain8002 {

    public static void main(String[] args){
        log.info("启动开始....");
        SpringApplication.run(PaymentMain8002.class,args);
        log.info("启动结束....");
    }
}
