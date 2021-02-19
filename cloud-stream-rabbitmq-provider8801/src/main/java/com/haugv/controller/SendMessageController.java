package com.haugv.controller;

import com.haugv.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    IMessageProvider provider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return provider.sendMessage();
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello~~";
    }
}
