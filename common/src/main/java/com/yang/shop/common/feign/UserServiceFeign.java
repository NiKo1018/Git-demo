package com.yang.shop.common.feign;

import com.yang.shop.common.dto.OrderUserDto;
import com.yang.shop.common.rollback.UserServiceFeginRollBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(value = "microservice-user",fallback = UserServiceFeginRollBack.class)
public interface UserServiceFeign {

    @RequestMapping("/user/detail/{id}")
    public OrderUserDto detail(@PathVariable("id")String id);
}
