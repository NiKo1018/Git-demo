package com.yang.shop.auth.service;

import com.yang.shop.auth.po.User;
public interface UserService{


    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
