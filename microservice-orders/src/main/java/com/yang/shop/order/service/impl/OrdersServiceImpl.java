package com.yang.shop.order.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yang.shop.order.po.Orders;
import com.yang.shop.order.mapper.OrdersMapper;
import com.yang.shop.order.service.OrdersService;
@Service
public class OrdersServiceImpl implements OrdersService{

    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return ordersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Orders record) {
        return ordersMapper.insert(record);
    }

    @Override
    public int insertSelective(Orders record) {
        return ordersMapper.insertSelective(record);
    }

    @Override
    public Orders selectByPrimaryKey(String id) {
        return ordersMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Orders record) {
        return ordersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Orders record) {
        return ordersMapper.updateByPrimaryKey(record);
    }

    @Override
    public void deleteOrderByUserId(String userId) {
        ordersMapper.deleteOrderByUserId(userId);
    }


}
