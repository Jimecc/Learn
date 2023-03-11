package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entities.Payment;

/**
 * @author Jim
 * @Description
 * @createTime 2022年08月02日
 */
public interface PaymentService {

    public Payment getPaymentById(Long id);

    public int create(Payment payment);
}
