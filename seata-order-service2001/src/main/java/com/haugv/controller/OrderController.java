package com.haugv.controller;

import com.haugv.common.CommonResult;
import com.haugv.domain.Order;
import com.haugv.service.db.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult createOrder(Order order){
        orderService.createOrder(order);
        return new CommonResult(200,"订单创建成功！",null);
    }
}
