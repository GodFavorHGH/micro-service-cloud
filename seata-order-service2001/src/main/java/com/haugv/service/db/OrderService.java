package com.haugv.service.db;

import com.haugv.domain.Order;

public interface OrderService {

    int createOrder(Order order);

    int updateOrderStatus(Order order);

}
