package com.yang.shop.auth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yang.shop.auth.mapper.UserProfilePhotoMapper;
import com.yang.shop.auth.po.UserProfilePhoto;
import com.yang.shop.auth.service.UserProfilePhotoService;
@Service
public class UserProfilePhotoServiceImpl implements UserProfilePhotoService{

    @Resource
    private UserProfilePhotoMapper userProfilePhotoMapper;

    @Override
    public int insert(UserProfilePhoto record) {
        return userProfilePhotoMapper.insert(record);
    }

    @Override
    public int insertSelective(UserProfilePhoto record) {
        return userProfilePhotoMapper.insertSelective(record);
    }

}
