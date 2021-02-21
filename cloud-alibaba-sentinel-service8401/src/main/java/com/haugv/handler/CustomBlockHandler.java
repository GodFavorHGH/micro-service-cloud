package com.haugv.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomBlockHandler {


    public static String handleException(BlockException exception){
        return "failure: 用户自定义兜底方法";
    }
}
