package com.yang.shop.auth.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com.yang.shop.auth.po.UserProfile")
@Data
public class UserProfile implements Serializable {
    @ApiModelProperty(value="null")
    private String id;

    @ApiModelProperty(value="null")
    private String sex;

    @ApiModelProperty(value="null")
    private Integer age;

    @ApiModelProperty(value="null")
    private String address;

    @ApiModelProperty(value="null")
    private String memo;

    @ApiModelProperty(value="null")
    private Date birthday;

    private static final long serialVersionUID = 1L;
}