package com.yang.shop.auth.mapper;

import com.yang.shop.auth.po.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> findMenusByUserId(String userId);

}