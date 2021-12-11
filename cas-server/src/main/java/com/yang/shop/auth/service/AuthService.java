package com.yang.shop.auth.service;

/**
 * @Description:
 * @Author: Tu Xu
 * @CreateDate: 2021/8/20 9:27
 * @Version: 1.0
 **/
public interface AuthService {

    public String generateToken(String userId);

    public String authentication(String token);

    public String authorization(String token, String path);

    public String getUserId(String token);
}
