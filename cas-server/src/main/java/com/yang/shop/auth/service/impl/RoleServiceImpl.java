package com.yang.shop.auth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yang.shop.auth.po.Role;
import com.yang.shop.auth.mapper.RoleMapper;
import com.yang.shop.auth.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{

    @Resource
    private RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public Role selectByPrimaryKey(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

}
