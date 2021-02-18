package com.haugv.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentOK(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentOK,id:"+id;
    }

    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String paymentTimeout(Integer id){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+" paymentTimeout,id:"+id;
    }

    public String paymentTimeoutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentTimeoutHandler,id:"+id+";超时异常返回预期备用响应~";
    }


}
