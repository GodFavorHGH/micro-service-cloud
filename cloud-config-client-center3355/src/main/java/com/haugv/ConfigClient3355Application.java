package com.haugv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClient3355Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3355Application.class,args);
    }

}
