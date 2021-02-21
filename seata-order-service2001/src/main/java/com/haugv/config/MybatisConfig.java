package com.haugv.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.haugv.mapper")
public class MybatisConfig {

}
