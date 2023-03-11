package com.atguigu.springcloud.controller;




import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jim
 * @Description
 * @createTime 2022年08月02日
 */
@RestController
@Slf4j
public class PaymentController {


    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getA(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("----> 获取 Payment+\t"+id);
        if(null != result) {
            return new CommonResult(200, "获取成功，serverPort："+serverPort, result);
        }else{
            return new CommonResult(444, "获取失败，serverPort："+serverPort);
        }
    }

    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("----> 插入成功");
        if(result>0) {
            return new CommonResult(200, "插入成功，serverPort："+serverPort, result);
        }else{
            return new CommonResult(444,"添加失败，serverPort："+serverPort);
        }
    }

    @GetMapping(value="/payment/discovery")
    public Object getDiscovery(){
        List<String> services =  discoveryClient.getServices();
        for(String element : services){
            log.info("-----element\t"+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("-----instances:"+instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
