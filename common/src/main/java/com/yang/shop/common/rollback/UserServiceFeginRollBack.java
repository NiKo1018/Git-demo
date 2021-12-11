package com.yang.shop.common.rollback;

import com.yang.shop.common.dto.OrderUserDto;
import com.yang.shop.common.feign.UserServiceFeign;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFeginRollBack implements UserServiceFeign {
    @Override
    public OrderUserDto detail(String id) {
        return OrderUserDto.getFailed();
    }
}
