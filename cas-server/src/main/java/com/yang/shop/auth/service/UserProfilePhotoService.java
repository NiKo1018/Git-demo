package com.yang.shop.auth.service;

import com.yang.shop.auth.po.UserProfilePhoto;
public interface UserProfilePhotoService{


    int insert(UserProfilePhoto record);

    int insertSelective(UserProfilePhoto record);

}
