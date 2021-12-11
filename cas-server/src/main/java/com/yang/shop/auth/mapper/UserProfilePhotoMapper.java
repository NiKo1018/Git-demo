package com.yang.shop.auth.mapper;

import com.yang.shop.auth.po.UserProfilePhoto;

public interface UserProfilePhotoMapper {
    int insert(UserProfilePhoto record);

    int insertSelective(UserProfilePhoto record);
}