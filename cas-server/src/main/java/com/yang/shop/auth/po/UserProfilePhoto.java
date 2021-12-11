package com.yang.shop.auth.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="com.yang.shop.auth.po.UserProfilePhoto")
@Data
public class UserProfilePhoto implements Serializable {
    @ApiModelProperty(value="null")
    private String id;

    @ApiModelProperty(value="null")
    private String picName;

    @ApiModelProperty(value="null")
    private String picUrl;

    @ApiModelProperty(value="null")
    private Integer userId;

    private static final long serialVersionUID = 1L;
}