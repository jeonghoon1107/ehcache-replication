package com.ehcache.ehcachereplication.config;

import lombok.RequiredArgsConstructor;
import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@EnableCaching
@RequiredArgsConstructor
public class EhcacheConfig {

    private final Environment env;
    public static final String CACHE_NAME = "replicationCache";

    @Bean
    public EhCacheCacheManager ehCacheCacheManager() {
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        ehCacheCacheManager.setCacheManager(cacheManager());
        return ehCacheCacheManager;
    }

    @Bean
    public CacheManager cacheManager() {
        if(env.acceptsProfiles("local1")) {
            return net.sf.ehcache.CacheManager.create("src/main/resources/ehcache1.xml");
        }
        return net.sf.ehcache.CacheManager.create("src/main/resources/ehcache2.xml");
    }
}
