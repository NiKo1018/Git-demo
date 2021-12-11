package com.yang.shop.auth.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com.yang.shop.auth.po.Role")
@Data
public class Role implements Serializable {
    @ApiModelProperty(value="null")
    private String id;

    @ApiModelProperty(value="null")
    private String englishName;

    @ApiModelProperty(value="null")
    private String chineseName;

    @ApiModelProperty(value="null")
    private Integer status;

    @ApiModelProperty(value="null")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}