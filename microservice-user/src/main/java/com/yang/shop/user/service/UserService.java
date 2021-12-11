package com.yang.shop.user.service;

import com.yang.shop.user.po.User;

public interface UserService {


    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    void deleteUserAndOrderByUserId(String id);
}

