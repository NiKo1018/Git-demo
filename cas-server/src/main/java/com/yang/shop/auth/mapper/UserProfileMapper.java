package com.yang.shop.auth.mapper;

import com.yang.shop.auth.po.UserProfile;

public interface UserProfileMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserProfile record);

    int insertSelective(UserProfile record);

    UserProfile selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserProfile record);

    int updateByPrimaryKey(UserProfile record);
}