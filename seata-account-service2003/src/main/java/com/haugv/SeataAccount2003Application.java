package com.haugv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
public class SeataAccount2003Application {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccount2003Application.class,args);
    }
}
