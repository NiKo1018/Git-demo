package com.yang.shop.zuul.config;



import com.yang.shop.zuul.cache.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;

/**
 * 缓冲配置类
 */
@Configuration
@EnableCaching
public class CacheConfig {
    @Autowired
    private RedisCache redisCache;

    @Bean("cacheManager")
    public SimpleCacheManager simpleCacheManager(){
        //缓冲管理器
        SimpleCacheManager simpleCacheManager=new SimpleCacheManager();

        HashSet<Cache> set = new HashSet<>();
        redisCache.setName("redisCache");
        set.add(redisCache);

        simpleCacheManager.setCaches(set);
        return simpleCacheManager;
    }
}
