package com.haugv.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {

    @GetMapping("/testA")
    public String testA(){
        /*try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "testB";
    }

    @GetMapping("/testD")
    public String testD(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "testD";
    }


    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealBlockExceptionHandler")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1, @RequestParam(value = "p2",required = false) String p2){
        return "testHotKey";
    }

    /**
     * 处理熔断的兜底方法
     * @param p1
     * @param p2
     * @param e 必须传BlockException  才会转换提示
     * @return
     */
    public String dealBlockExceptionHandler(String p1, String p2, BlockException e){
        return "热点key熔断兜底处理：";
    }
}
