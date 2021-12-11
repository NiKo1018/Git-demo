package com.yang.shop.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.yang.shop.common.feign.CasServiceFegin;
import com.yang.shop.common.vo.ResponseVo;
import com.yang.shop.zuul.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 cas-server  登录的接口  颁布jwt
             身份认证的接口（网关服务需要消费）
 (jwt,uri)
              注册
              找回密码

 **/
@Component
public class AuthenticationFliter extends ZuulFilter {

    // @Autowired
    // private CasServiceFegin casServiceFegin;

    @Autowired
    private AuthService authService;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //判断目标资源是否是公共资源 /common
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request=rc.getRequest();
       // /microservice-user/user/detail/{id}
        String uri=request.getRequestURI();
        //判断url是否是包含公开资源(静态资源、动态资源(注册 登录 发短息 忘记密码...))
        if(uri.contains("/common")){
            return false;
        }else{
            return true;
        }

    }

    @Override
    public Object run() throws ZuulException {
        //身份认证
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        String uri=request.getRequestURI();
        System.out.println("uri = " + uri);
        //
        String token = null;
        if ((token = request.getHeader("token")) == null) {
            token = request.getParameter("token");
        }
        if (token == null) {
            rc.setSendZuulResponse(false);
            //添加一个响应的状态码
            rc.setResponseStatusCode(401);
            //响应内容
            rc.setResponseBody("{\"status\":\"400\",message:token不存在}");
            //响应类型
            rc.getResponse().setContentType("text/json;charset=utf-8");
        } else {
            //调权限服务...
            //调用cas-server 进行身份认证以及权限认证即可
            String code = authService.authentication(token);
            if("200".equals(code)){
                //身份认证成功
                String authorization = authService.authorization(token, uri);
                if("200".equals(authorization)){
                    //权限认证成功
                    System.out.println("权限认证成功！");
                }else{
                    //权限认证失败
                    rc.setSendZuulResponse(false);
                    //添加一个响应的状态码
                    rc.setResponseStatusCode(505);
                    //响应内容
                    rc.setResponseBody("{\"status\":\"505\",message:权限认证失败}");
                    //响应类型
                    rc.getResponse().setContentType("text/json;charset=utf-8");
                }

            }else{
                //身份认证失败
                rc.setSendZuulResponse(false);
                //添加一个响应的状态码
                rc.setResponseStatusCode(506);
                //响应内容
                rc.setResponseBody("{\"status\":\"506\",message:身份认证失败}");
                //响应类型
                rc.getResponse().setContentType("text/json;charset=utf-8");
            }

        }


        return null;
    }
}
