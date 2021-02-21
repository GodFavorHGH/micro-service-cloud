package com.haugv.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "/account/deduct")
    int deductAccountBalance(@RequestParam("userId") String userId, @RequestParam("money") int money);

}
