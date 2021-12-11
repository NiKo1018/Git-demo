package com.yang.shop.auth.controller;

import com.yang.shop.auth.service.AuthService;
import com.yang.shop.common.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Authcontroller {

    @Autowired
    private AuthService authService;

    @RequestMapping("/common/{id}")
    public ResponseVo token(@PathVariable("id")String id){
        return new ResponseVo("200",authService.generateToken(id),"根据id生成一个token");
    }
    @RequestMapping("/authorization")
    public ResponseVo authorization(@RequestParam("token")String token,@RequestParam("path")String path){
        return new ResponseVo("200",authService.authorization(token,path),"授权信息");
    }


    @RequestMapping("/authentication/{token}")
    public ResponseVo authentication(@PathVariable("token")String token){
        return new ResponseVo("200",authService.authentication(token),"身份认证信息");
    }
}
