package com.yang.shop.auth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yang.shop.auth.po.UserProfile;
import com.yang.shop.auth.mapper.UserProfileMapper;
import com.yang.shop.auth.service.UserProfileService;
@Service
public class UserProfileServiceImpl implements UserProfileService{

    @Resource
    private UserProfileMapper userProfileMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return userProfileMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserProfile record) {
        return userProfileMapper.insert(record);
    }

    @Override
    public int insertSelective(UserProfile record) {
        return userProfileMapper.insertSelective(record);
    }

    @Override
    public UserProfile selectByPrimaryKey(String id) {
        return userProfileMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserProfile record) {
        return userProfileMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserProfile record) {
        return userProfileMapper.updateByPrimaryKey(record);
    }

}
