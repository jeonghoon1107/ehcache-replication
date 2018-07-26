package com.ehcache.ehcachereplication.controller;

import com.ehcache.ehcachereplication.service.CacheReplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("cache")
@RequiredArgsConstructor
public class CacheController {

    private final CacheReplicationService cacheReplicationService;

    @GetMapping("replication")
    public Integer replication() {
        return this.cacheReplicationService.getCachedReplicationValue();
    }

    @GetMapping("increase")
    public Integer increase() {
        return this.cacheReplicationService.getReplicationValue();
    }
}
