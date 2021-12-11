package com.yang.shop.order.service;

import com.yang.shop.order.po.Orders;
public interface OrdersService{


    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    void deleteOrderByUserId(String userId);
}
