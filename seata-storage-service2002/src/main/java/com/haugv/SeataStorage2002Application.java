package com.haugv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SeataStorage2002Application {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorage2002Application.class,args);
    }
}
