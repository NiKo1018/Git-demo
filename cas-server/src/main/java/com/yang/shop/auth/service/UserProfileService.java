package com.yang.shop.auth.service;

import com.yang.shop.auth.po.UserProfile;
public interface UserProfileService{


    int deleteByPrimaryKey(String id);

    int insert(UserProfile record);

    int insertSelective(UserProfile record);

    UserProfile selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserProfile record);

    int updateByPrimaryKey(UserProfile record);

}
