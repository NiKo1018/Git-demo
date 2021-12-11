package com.yang.shop.auth.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="com.yang.shop.auth.po.User")
@Data
public class User implements Serializable {
    @ApiModelProperty(value="null")
    private String id;

    @ApiModelProperty(value="null")
    private String username;

    @ApiModelProperty(value="null")
    private String password;

    @ApiModelProperty(value="null")
    private String phone;

    private static final long serialVersionUID = 1L;
}