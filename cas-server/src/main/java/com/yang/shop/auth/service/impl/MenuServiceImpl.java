package com.yang.shop.auth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yang.shop.auth.mapper.MenuMapper;
import com.yang.shop.auth.po.Menu;
import com.yang.shop.auth.service.MenuService;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    @Resource
    private MenuMapper menuMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Menu record) {
        return menuMapper.insert(record);
    }

    @Override
    public int insertSelective(Menu record) {
        return menuMapper.insertSelective(record);
    }

    @Override
    public Menu selectByPrimaryKey(String id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return menuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return menuMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Menu> findMenusByUserId(String userId) {
        return menuMapper.findMenusByUserId(userId);
    }

}
