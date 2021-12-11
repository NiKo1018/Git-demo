package com.yang.shop.auth.service;

import com.yang.shop.auth.po.Role;
public interface RoleService{


    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

}
