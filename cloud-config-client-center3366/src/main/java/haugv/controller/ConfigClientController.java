package haugv.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${name}")
    String name;

    @Value("${server.port}")
    String port;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return "端口："+port+";name:"+name;
    }

}
