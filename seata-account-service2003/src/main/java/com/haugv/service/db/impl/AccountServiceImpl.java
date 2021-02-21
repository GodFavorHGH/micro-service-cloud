package com.haugv.service.db.impl;

import com.haugv.mapper.AccountMapper;
import com.haugv.service.db.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountMapper accountMapper;

    @Override
    public int deductAccountBalance(String userId, int money) {
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return accountMapper.deductAccountBalance(userId, money);
    }
}
