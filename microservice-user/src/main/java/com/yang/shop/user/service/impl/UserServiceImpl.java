package com.yang.shop.user.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.yang.shop.common.dto.CommonsDto;
import com.yang.shop.common.feign.OrderServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yang.shop.user.po.User;
import com.yang.shop.user.mapper.UserMapper;
import com.yang.shop.user.service.UserService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Autowired(required = false)
    private OrderServiceFeign orderServiceFeign;
    @Override
    public int deleteByPrimaryKey(String id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    @Transactional
    @TxTransaction(isStart = true)
    public void deleteUserAndOrderByUserId(String id) {
        //1.删除用户
        userMapper.deleteByPrimaryKey(id);
        //2.删除用户对应的订单
        CommonsDto delete = orderServiceFeign.delete(id);

        int i=2/0;

        //如果不加事务管理器，
        //先调用远程的方法，调用成功，再调用本地的方法时出现异常；
        //远程的无法回滚，本地的可以回滚，造成数据的不一致性
    }

}

