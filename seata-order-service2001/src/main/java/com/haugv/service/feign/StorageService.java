package com.haugv.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/storage/deduct")
    int deductStorageCount(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") int count);
}
