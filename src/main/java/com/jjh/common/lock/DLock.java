package com.jjh.common.lock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * DLock
 *
 * @author jiangjihui
 * @date 2024/09/11
 **/
@Slf4j
@RequiredArgsConstructor
@Component
public class DLock {

    private final RedissonClient redissonClient;

    public boolean tryLock(String key, long waitTime, long leaseTime, TimeUnit unit) {
        boolean isLock = false;
        RLock lock = redissonClient.getLock(key);
        try {
            isLock = lock.tryLock(waitTime, leaseTime, unit);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (!isLock) {
            log.info("lock failed. key: {}", key);
        }
        return isLock;
    }

    public void unLock(String key) {
        RLock lock = redissonClient.getLock(key);
        if (lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }
}
