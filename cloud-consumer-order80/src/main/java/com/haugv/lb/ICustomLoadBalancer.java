package com.haugv.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface ICustomLoadBalancer {

    ServiceInstance instance(List<ServiceInstance> instances);


}
