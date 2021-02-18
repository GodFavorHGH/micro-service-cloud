package com.haugv.controller;

import cn.hutool.core.lang.UUID;
import com.haugv.entity.CommonResult;
import com.haugv.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderZkController {

    public static final String REMOTE_PAYMENT_API_URL = "http://CLOUD-PAYMENT-SERVICE";
    public static final String PAYMENT_API_CREATE = "/payment/create";
    public static final String PAYMENT_API_GET = "/payment/get";

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(REMOTE_PAYMENT_API_URL + PAYMENT_API_CREATE, payment, CommonResult.class);
    }


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(REMOTE_PAYMENT_API_URL + PAYMENT_API_GET +"/" +id, CommonResult.class);
    }

    @Value("${server.port}")
    String port;

    @GetMapping("/order/zk")
    public String orderZk(){
        return "spring cloud with zookeeper:"+port+"\t"+ UUID.randomUUID().toString();
    }


    @GetMapping("/consumer/payment/zk")
    public String getPaymentZk(){
        return restTemplate.getForObject("http://cloud-payment-service/payment/zk", String.class);
    }
}
