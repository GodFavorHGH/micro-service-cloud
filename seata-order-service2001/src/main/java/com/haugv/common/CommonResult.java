package com.haugv.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResult<T> {

    private int code;
    private String message;
    private T data;

    public CommonResult(int code, String message) {
        this(code,message,null);
    }
}
