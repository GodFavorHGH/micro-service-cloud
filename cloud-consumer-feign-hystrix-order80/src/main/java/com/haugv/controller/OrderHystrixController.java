package com.haugv.controller;

import com.haugv.entity.CommonResult;
import com.haugv.entity.Payment;
import com.haugv.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderHystrixController {

    @Resource
    PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentOK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentOK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentTimeout(id);
    }


}
