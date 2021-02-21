package com.haugv.service.db.impl;

import com.haugv.common.CommonResult;
import com.haugv.domain.Order;
import com.haugv.mapper.OrderMapper;
import com.haugv.service.db.OrderService;
import com.haugv.service.feign.AccountService;
import com.haugv.service.feign.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper mapper;
    @Resource
    StorageService storageService;
    @Resource
    AccountService accountService;


    @Override
    @GlobalTransactional(name = "fsp_create_order",rollbackFor = Exception.class)//name属性的值可以随意起
    public int createOrder(Order order) {
        log.info("-----------------创建订单-----------");
        mapper.createOrder(order);
        log.info("-----------------减库存-----------");
        storageService.deductStorageCount(order.getCommodityCode(), order.getCount());
        log.info("-----------------减账户余额-----------");
        accountService.deductAccountBalance(order.getUserId(), order.getMoney());
        log.info("-----------------修改订单状态-----------");
        mapper.updateOrderStatus(order);
        log.info("-----------------下订单结束-----------");
        return 200;
    }

    @Override
    public int updateOrderStatus(Order order) {
        return mapper.updateOrderStatus(order);
    }
}
