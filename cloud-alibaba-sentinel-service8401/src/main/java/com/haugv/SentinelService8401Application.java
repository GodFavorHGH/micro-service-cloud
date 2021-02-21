package com.haugv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelService8401Application {


    public static void main(String[] args) {
        SpringApplication.run(SentinelService8401Application.class,args);
    }

}
