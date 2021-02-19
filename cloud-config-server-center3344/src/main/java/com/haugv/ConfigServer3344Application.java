package com.haugv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServer3344Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer3344Application.class,args);
    }
}
