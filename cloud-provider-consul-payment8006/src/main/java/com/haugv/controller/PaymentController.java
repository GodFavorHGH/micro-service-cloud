package com.haugv.controller;

import cn.hutool.core.lang.UUID;
import com.haugv.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService service;

    @Value("${server.port}")
    String port;

    /*@PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment p){
        int res = service.create(p);
        log.info("插入结果："+res);
        return res==1?new CommonResult(200, "成功"+":端口:"+port, p):new CommonResult(444, "失败"+":端口:"+port, p);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = service.getPaymentById(id);
        return payment!=null?new CommonResult(200, "成功"+":端口:"+port, payment):new CommonResult(444, "无记录"+":端口:"+port);
    }*/

    @GetMapping("/payment/zk")
    public String paymentZk(){
        return "spring cloud with zookeeper:"+port+"\t"+ UUID.randomUUID().toString();
    }

    @GetMapping("/payment/consul")
    public String paymentConsul(){
        return "spring cloud with consul:"+port+"\t"+ UUID.randomUUID().toString();
    }

}
