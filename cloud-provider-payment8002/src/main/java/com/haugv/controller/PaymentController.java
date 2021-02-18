package com.haugv.controller;

import com.haugv.entity.CommonResult;
import com.haugv.entity.Payment;
import com.haugv.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService service;

    @Value("${server.port}")
    String port;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment p){
        int res = service.create(p);
        log.info("插入结果："+res);
        return res==1?new CommonResult(200, "成功"+":端口:"+port, p):new CommonResult(444, "失败"+":端口:"+port, p);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = service.getPaymentById(id);
        return payment!=null?new CommonResult(200, "成功"+":端口:"+port, payment):new CommonResult(444, "无记录"+":端口:"+port);
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return port;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }
}
