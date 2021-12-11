package com.yang.shop.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 @EnableEurekaClient 开启eureka客户端 开启服务注册
 @EnableDiscoveryClient 开启服务发现（订阅）
 eureka服务注册的过程
 1:服务启动之后，通过eurekaClient向eurekaServer注册自己的服务id和服务名称，eureka-server会将服务的注册信息保存到内存中
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan("com.yang.shop.order.mapper")
@EnableTransactionManagement
@EnableFeignClients({"com.yang.shop.common.feign","com.codingapi.tx"})
@ComponentScan("com.yang.shop")
// @EnableHystrix
public class OrdersServer {

    public static void main(String[] args) {
        SpringApplication.run(OrdersServer.class, args);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
