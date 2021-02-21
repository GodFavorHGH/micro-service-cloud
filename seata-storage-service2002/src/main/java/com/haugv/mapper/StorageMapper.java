package com.haugv.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageMapper {

    int deductStorageCount(@Param("commodityCode") String commodityCode, @Param("count") int count);

}
