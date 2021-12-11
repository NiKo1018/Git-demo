package com.yang.shop.common.feign;

import com.yang.shop.common.dto.CommonsDto;
import com.yang.shop.common.rollback.UserServiceFeginRollBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "microservice-orders")
public interface OrderServiceFeign {
    @RequestMapping("/orders/delete")
    public CommonsDto delete(@RequestParam String userId);
}
