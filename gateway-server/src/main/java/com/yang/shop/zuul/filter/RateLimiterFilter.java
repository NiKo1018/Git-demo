package com.yang.shop.zuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
漏桶算法
 以任意速率往桶中放入请求，如果桶中的请求没有满的话，可以访问服务。

 令牌桶算法(控制住qps)
 每秒生产一定数量的令牌，并存放到桶中，用户的每次请求
 都要去桶中取到令牌，取到令牌就放行，取不到就拒绝请求

 Nginx限流(基于以上两种算法实现)
  1：设置最大连接数
  2:可以设置统一ip地址，每秒请求的频率  1秒一次
  3:设置ip白名单和黑名单.
 **/
@Component
public class RateLimiterFilter extends ZuulFilter {
    //每秒产生5000个令牌
    private static final RateLimiter RATE_LIMITER=RateLimiter.create(5000);

    /**过滤器的类型
     * pre
     * after
     *
     * **/
    @Override
    public String filterType() {
        return "pre";
    }
   /**
    过滤顺序 自然顺序，数字越小，越在前面(外层)
     **/
    @Override
    public int filterOrder() {
        return -1;
    }
    /**
    是否进行过滤
      **/
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /**
     过滤器的执行逻辑
      **/
    @Override
    public Object run() throws ZuulException {
        //取到http请求
        RequestContext rc = RequestContext.getCurrentContext();
        if(RATE_LIMITER.tryAcquire()){
            //取到令牌
            System.out.println("取到令牌，转发请求!");

        }else{
            //没取到令牌
            //直接响应,不转发请求
            rc.setSendZuulResponse(false);
            //添加一个响应的状态码
            rc.setResponseStatusCode(401);
            //响应内容
            rc.setResponseBody("{\"status\":\"500\",message:服务器忙，请稍后再试}");
            //响应类型
            rc.getResponse().setContentType("text/json;charset=utf-8");
        }
        return null;
    }
}
