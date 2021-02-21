package com.haugv.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosPaymentController {

    @Value("${server.port}")
    String port;

    @GetMapping("/nacos/get")
    public String get(){
        return "from port:"+port;
    }
}
