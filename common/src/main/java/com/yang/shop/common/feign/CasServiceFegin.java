package com.yang.shop.common.feign;

import com.yang.shop.common.dto.OrderUserDto;
import com.yang.shop.common.rollback.UserServiceFeginRollBack;
import com.yang.shop.common.vo.ResponseVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cas-server")
public interface CasServiceFegin {

    @RequestMapping("/auth/token/{id}")
    public ResponseVo token(@PathVariable("id")String id);

    @RequestMapping("/auth/authorization")
    public ResponseVo authorization(@RequestParam("token")String token, @RequestParam("path")String path);

    @RequestMapping("/auth/authentication/{token}")
    public ResponseVo authentication(@PathVariable("token")String token);
}
