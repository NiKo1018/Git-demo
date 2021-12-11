package com.yang.shop.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.yang.shop.auth.po.Menu;
import com.yang.shop.auth.po.User;
import com.yang.shop.auth.service.AuthService;
import com.yang.shop.auth.service.MenuService;
import com.yang.shop.auth.service.UserService;
import com.yang.shop.common.vo.ResponseVo;
import com.yang.shop.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: Tu Xu
 * @CreateDate: 2021/8/20 9:31
 * @Version: 1.0
 **/
@Service

public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Override
    public String generateToken(String userId) {
        User user = userService.selectByPrimaryKey(userId);
        return JwtUtil.gerenateToken(user);
    }

    @Override
    public String authentication(String token) {
        //失效时间
        Date expireTime;
        ResponseVo vo;
        try {
            expireTime = JwtUtil.getExpireAt(token);
        } catch (Exception e) {
            //token不符合规范
            vo = new ResponseVo("500", null, "token无效,请重新登录！");
            return JSON.toJSONString(vo);
        }

        if (System.currentTimeMillis() < expireTime.getTime()) {
            //token未过期
            String userId;
            try {
                userId = JwtUtil.getUserId(token);
            } catch (Exception e) {
                //token不符合规范
                vo = new ResponseVo("500", null, "用户身份信息被篡改,请重新登录！");

                return JSON.toJSONString(vo);
            }
            //需要验签，拿用户的密码进行验签
            User user = userService.selectByPrimaryKey(userId);
            String password = user.getPassword();

            try {
                JwtUtil.verify(password, token);
                vo = new ResponseVo("200", null, "用户身份认证成功");
                //验签成功了
                return JSON.toJSONString(vo);
            } catch (Exception e) {
                //验签失败了
                vo = new ResponseVo("500", null, "验签失败");

                return JSON.toJSONString(vo);
            }
        }else {
            vo = new ResponseVo("500", null, "token过期,请重新登录！");

            return JSON.toJSONString(vo);
        }

        }

        @Override
        public String authorization (String token,String path){
           ResponseVo responseVo;
           String userId=JwtUtil.getUserId(token);
            List<Menu> menuList=menuService.findMenusByUserId(userId);
            boolean check=false;
            for(Menu menu:menuList){
                if(path.contains(menu.getMenuKey())){
                    check=true;
                    break;
                }
            }
            if(check){
                //权限认证通过
                responseVo=new ResponseVo("200", JSON.toJSONString(menuList), "权限认证成功!");
            }else{
                //权限认证失败
                responseVo=new ResponseVo("500", JSON.toJSONString(menuList), "权限认证失败!");
            }
            return JSON.toJSONString(responseVo);

        }

    @Override
    public String getUserId(String token) {
        return JwtUtil.getUserId(token);
    }
}
