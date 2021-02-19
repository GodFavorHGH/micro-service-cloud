package com.haugv.service;

import cn.hutool.core.util.IdUtil;
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

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_callback",commandProperties = {
            //确定当服务请求命令失败时，是否使用断路器来跟踪其健康指标和熔断请求。默认为true。
            //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            //用来设置在滚动时间窗中，断路器熔断的最小请求数。例如，默认该值为20的时候，如果滚动时间窗（默认10秒）内仅收到19个请求，即使这19个请求都失败了，断路器也不会打开。
            //请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //用来设置当断路器打开之后的休眠时间窗。休眠时间窗结束之后，会将断路器设置为“半开”状态，尝试熔断的请求命令，如果依然时候就将断路器继续设置为“打开”状态，如果成功，就设置为“关闭”状态。
            //时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            //该属性用来设置断路器打开的错误百分比条件。默认值为50，表示在滚动时间窗中，在请求值超过requestVolumeThreshold阈值的前提下，如果错误请求数百分比超过50，就把断路器设置为“打开”状态，否则就设置为“关闭”状态。
            //失败率达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
        }
    )
    public String paymentCircuitBreaker(Integer id){
        if (id<0){
            throw new RuntimeException("id不能为负数");
        }
        String jnl = IdUtil.simpleUUID();
        return "线程池："+Thread.currentThread().getName()+" paymentCircuitBreaker,流水:"+jnl;
    }

    public String paymentCircuitBreaker_callback(Integer id){
        return "id不能为负数，晴稍后再试!";
    }

}
