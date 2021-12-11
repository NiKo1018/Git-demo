package com.yang.shop.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderUserDto {

    private String code;
    private String message;
    private String username;

    public static OrderUserDto getFailed(){
        return new OrderUserDto("500","服务调用失败，请重试！",null);
    }
}
