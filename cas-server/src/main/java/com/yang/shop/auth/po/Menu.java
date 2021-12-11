package com.yang.shop.auth.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com.yang.shop.auth.po.Menu")
@Data
public class Menu implements Serializable {
    @ApiModelProperty(value="null")
    private String id;

    @ApiModelProperty(value="null")
    private String parentId;

    /**
    * 菜单名称
    */
    @ApiModelProperty(value="菜单名称")
    private String menuName;

    @ApiModelProperty(value="null")
    private String menuLogo;

    @ApiModelProperty(value="null")
    private String menuUrl;

    @ApiModelProperty(value="null")
    private Integer status;

    @ApiModelProperty(value="null")
    private Date createTime;

    @ApiModelProperty(value="null")
    private String menuKey;

    private static final long serialVersionUID = 1L;
}