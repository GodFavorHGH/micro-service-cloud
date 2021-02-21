package com.haugv.service.db.impl;

import com.haugv.mapper.StorageMapper;
import com.haugv.service.db.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    StorageMapper storageMapper;

    @Override
    public int deductStorageCount(String commodityCode, int count) {
        return storageMapper.deductStorageCount(commodityCode,count);
    }
}
