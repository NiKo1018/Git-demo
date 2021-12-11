package com.yang.shop.zuul.service.impl;

import com.yang.shop.common.feign.CasServiceFegin;
import com.yang.shop.common.feign.UserServiceFeign;
import com.yang.shop.common.vo.ResponseVo;
import com.yang.shop.zuul.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

@CacheConfig(cacheManager = "cacheManager",cacheNames = "redisCache")
@Service
public class AuthServiceImpl implements AuthService {


    @Autowired
    private CasServiceFegin casServiceFegin;
    @Override
    public String generateToken(String userId) {
        return null;
    }

    @Override
    @Cacheable(key = "'token:'+#token")
    public String authentication(String token) {
        System.out.println("token = " + token);
        ResponseVo authentication = casServiceFegin.authentication(token);
        return authentication.getStatus();
    }

    @Override
    @Cacheable(key = "'token:path,'+#token+#path")
    public String authorization(String token, String path) {
        System.out.println("token = " + token);
        System.out.println("path = " + path);
        ResponseVo authorization = casServiceFegin.authorization(token, path);
        return authorization.getStatus();
    }

    @Override
    public String getUserId(String token) {
        return null;
    }
}
