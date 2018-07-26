package com.ehcache.ehcachereplication.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.ehcache.ehcachereplication.config.EhcacheConfig.CACHE_NAME;

@Slf4j
@Service
@RequiredArgsConstructor
public class CacheReplicationService {

    @Value("${replication.value}")
    private Integer replicationValue;

    @CachePut(cacheNames = CACHE_NAME)
    public Integer getReplicationValue() {
        return ++replicationValue;
    }

    @Cacheable(cacheNames = CACHE_NAME)
    public int getCachedReplicationValue() {
        return replicationValue;
    }
}
