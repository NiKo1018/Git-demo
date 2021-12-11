package com.yang.shop.order.mapper;

import com.yang.shop.order.po.Orders;

public interface OrdersMapper {
    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);


    void deleteOrderByUserId(String userId);
}