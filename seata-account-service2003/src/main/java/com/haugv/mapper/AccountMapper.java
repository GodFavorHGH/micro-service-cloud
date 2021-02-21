package com.haugv.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {

    int deductAccountBalance(@Param("userId") String userId, @Param("money") int money);

}
