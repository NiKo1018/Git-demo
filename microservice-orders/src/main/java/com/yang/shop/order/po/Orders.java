package com.yang.shop.order.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="com.yang.shop.order.po.Orders")
public class Orders implements Serializable {
    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 用户id
    */
    @ApiModelProperty(value="用户id")
    private String userId;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * 金额
    */
    @ApiModelProperty(value="金额")
    private Long money;

    /**
    * 默认0 未付款 1 已付款
    */
    @ApiModelProperty(value="默认0 未付款 1 已付款")
    private Integer status;

    /**
    * 默认0 未删除 1已删除
    */
    @ApiModelProperty(value="默认0 未删除 1已删除")
    private Integer delState;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelState() {
        return delState;
    }

    public void setDelState(Integer delState) {
        this.delState = delState;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append(", money=").append(money);
        sb.append(", status=").append(status);
        sb.append(", delState=").append(delState);
        sb.append("]");
        return sb.toString();
    }
}