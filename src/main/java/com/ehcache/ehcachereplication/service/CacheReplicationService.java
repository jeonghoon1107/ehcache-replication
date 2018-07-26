package com.ehcache.ehcachereplication.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CacheReplicationService {

    @Value("${replication.value}")
    private Integer replicationValue;

    @CachePut(cacheNames = "replicationCache")
    public Integer getReplicationValue() {
        return ++replicationValue;
    }

    @Cacheable(cacheNames = "replicationCache")
    public int getCachedReplicationValue() {
        return ++replicationValue;
    }
}
