package com.yang.shop.zuul;

import com.yang.shop.zuul.config.CacheConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient //开启服务注册发现功能
@EnableDiscoveryClient
@EnableZuulProxy//开启网关
@EnableFeignClients("com.yang.shop.common.feign") //扫描fegin接口
@Import({CacheConfig.class}) //导入缓存配置类
public class ZuulServer {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServer.class,args);
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
