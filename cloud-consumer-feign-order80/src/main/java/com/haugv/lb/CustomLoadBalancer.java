package com.haugv.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
//让ioc容器可以扫描到
public class CustomLoadBalancer implements ICustomLoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next = 0;
        do {
            current = this.atomicInteger.get();
            next = current>=Integer.MAX_VALUE?0:current+1;
        }while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("第几次访问："+next);
        return next;
    }


    @Override
    public ServiceInstance instance(List<ServiceInstance> instances) {
        int index = getAndIncrement()%instances.size();
        return instances.get(index);
    }
}
