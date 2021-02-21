package com.haugv.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NacosOrderController {

    @Resource
    RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    String serverUrl;

    @GetMapping("/consumer/nacos/get")
    public String get(){
        return restTemplate.getForObject(serverUrl+"/nacos/get", String.class);
    }
}
