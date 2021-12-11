package com.yang.shop.auth.service;

import com.yang.shop.auth.po.Menu;

import java.util.List;

public interface MenuService{


    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> findMenusByUserId(String userId);
}
