package com.haugv.handler;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {



    @GetMapping("/rateLimit/customBlockHandler")
    @SentinelResource(value = "customBlockHandler", blockHandlerClass = CustomBlockHandler.class, blockHandler = "handleException")
    public String customBlockHandler(){
        return "success: 用户自定义限流";
    }


}
