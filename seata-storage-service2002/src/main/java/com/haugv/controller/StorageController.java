package com.haugv.controller;

import com.haugv.service.db.StorageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class StorageController {

    @Resource
    StorageService storageService;

    @PostMapping(value = "/storage/deduct")
    int deductStorageCount(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") int count){
        return storageService.deductStorageCount(commodityCode, count);
    }

    @RequestMapping(value = "/storage/test")
    public String testStorage(){
        return "feign from storage";
    }
}
