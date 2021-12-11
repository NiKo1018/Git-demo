package com.yang.shop.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description:
 * @Author: Tu Xu
 * @CreateDate: 2021/12/3 2:37
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
public class CommonsDto {
    private Boolean isSucess;
    private String message;

    public static CommonsDto getSuccess(){
        CommonsDto commonsDto=new CommonsDto(true, "success");
        return commonsDto;
    }
}
