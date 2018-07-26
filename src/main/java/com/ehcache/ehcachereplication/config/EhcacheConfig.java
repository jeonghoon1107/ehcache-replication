package com.ehcache.ehcachereplication.config;

import lombok.RequiredArgsConstructor;
import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
@RequiredArgsConstructor
public class EhcacheConfig {

    @Bean
    public EhCacheCacheManager ehCacheCacheManager() {
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        ehCacheCacheManager.setCacheManager(cacheManager());
        return ehCacheCacheManager;
    }

    @Bean
    public CacheManager cacheManager() {
        return net.sf.ehcache.CacheManager.getInstance();
    }
}
