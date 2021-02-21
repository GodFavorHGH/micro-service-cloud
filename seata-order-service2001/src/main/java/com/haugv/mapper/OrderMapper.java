package com.haugv.mapper;

import com.haugv.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    int createOrder(Order order);

    int updateOrderStatus(Order order);

}
