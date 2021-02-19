package com.haugv.service;


import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixFallback implements PaymentHystrixService{

    @Override
    public String paymentOK(Integer id) {
        return "支付异常";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "服务超时";
    }
}
