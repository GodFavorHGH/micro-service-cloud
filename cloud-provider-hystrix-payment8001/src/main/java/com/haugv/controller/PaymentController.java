package com.haugv.controller;

import com.haugv.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    String port;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentOK(@PathVariable("id") Integer id){
        return port + paymentService.paymentOK(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id){
        return port + paymentService.paymentTimeout(id);
    }

}
