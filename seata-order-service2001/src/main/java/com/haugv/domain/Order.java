package com.haugv.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private int id;
    private String userId;
    private String commodityCode;
    private int count;
    private int money;
    private int status;

}
