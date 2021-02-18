package com.haugv.controller;

import com.haugv.entity.CommonResult;
import com.haugv.entity.Payment;
import com.haugv.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService service;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment p){
        int res = service.create(p);
        log.info("插入结果："+res);
        return res==1?new CommonResult(200, "成功", p):new CommonResult(444, "失败", p);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = service.getPaymentById(id);
        return payment!=null?new CommonResult(200, "成功", payment):new CommonResult(444, "无记录");
    }
}
