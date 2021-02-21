package com.haugv.controller;

import com.haugv.service.db.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AccountController {

    @Resource
    AccountService accountService;

    @PostMapping(value = "/account/deduct")
    int deductAccountBalance(@RequestParam("userId") String userId, @RequestParam("money") int money){
        return accountService.deductAccountBalance(userId, money);
    }
}
