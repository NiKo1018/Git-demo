package com.yang.shop.user;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/***
 *  @EnableEurekaClient 开启eureka客户端 开启服务注册
 *  @EnableDiscoveryClient 开启服务发现（订阅）
 *  eureka服务注册的过程
 *  1:服务启动之后，通过eurekaClient向eurekaServer注册自己的服务id和服务名称，eureka-server会将服务的注册信息保存到内存中
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan("com.yang.shop.user.mapper")
@EnableTransactionManagement
@ComponentScan("com.yang.shop")
@EnableFeignClients({"com.yang.shop.common.feign","com.codingapi.tx"})
// @EnableApolloConfig
public class UserServer {
    public static void main(String[] args) {
        SpringApplication.run(UserServer.class,args);
    }
}
