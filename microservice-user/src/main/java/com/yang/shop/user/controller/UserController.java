package com.yang.shop.user.controller;


import com.yang.shop.common.dto.OrderUserDto;
import com.yang.shop.common.feign.UserServiceFeign;
import com.yang.shop.common.vo.ResponseVo;
import com.yang.shop.user.po.User;
import com.yang.shop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Tu Xu
 * @CreateDate: 2021/11/30 4:37
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController implements UserServiceFeign {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @RequestMapping("/detail/{id}")
    public OrderUserDto detail(@PathVariable("id") String id){
        System.out.println(6662);
        User user = userService.selectByPrimaryKey(id);
        OrderUserDto orderUserDto=new OrderUserDto();
        orderUserDto.setUsername(user.getUsername());
        return orderUserDto;
    }

    @RequestMapping("/delte")
    public ResponseVo DeleteUserById(@RequestParam("id")String id){
        userService.deleteUserAndOrderByUserId(id);
        return new ResponseVo("200",null,"删除成功！");
    }
}
