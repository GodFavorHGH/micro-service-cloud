package com.haugv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动装配，用自己的数据源
@EnableDiscoveryClient
@EnableFeignClients
public class SeataOrder2001Application {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrder2001Application.class,args);
    }
}
