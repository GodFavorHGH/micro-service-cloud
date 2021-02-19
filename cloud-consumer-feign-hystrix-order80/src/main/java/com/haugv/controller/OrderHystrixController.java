package com.haugv.controller;

import com.haugv.entity.CommonResult;
import com.haugv.entity.Payment;
import com.haugv.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentTimeout_default")
public class OrderHystrixController {

    @Resource
    PaymentHystrixService paymentHystrixService;

    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentOK(@PathVariable("id") Integer id){
        int a = 1/0;
        return paymentHystrixService.paymentOK(id);
    }

//    @HystrixCommand(fallbackMethod = "orderTimeoutHandler",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")})
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id){
        int a = 1/0;
        return paymentHystrixService.paymentTimeout(id);
    }

    /**
     * 指定的fallback，如果没有使用指定的fallback，则会调用默认的全局fallback
     * 指定的fallback参数需一致
     * @param id
     * @return
     */
    public String orderTimeoutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+" orderTimeoutHandler,id:"+id+";超时异常返回预期备用响应~";
    }

    /**
     * 全局fallback，改方法不能带参数，不然会报错找不到fallback
     * @return
     */

    public String paymentTimeout_default(){
        return "全局异常兜底处理";
    }


}
