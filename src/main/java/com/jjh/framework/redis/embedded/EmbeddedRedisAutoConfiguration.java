package com.jjh.framework.redis.embedded;

import jakarta.annotation.PreDestroy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;
import redis.embedded.RedisServerBuilder;

import java.io.IOException;

@Configuration
@EnableConfigurationProperties(EmbeddedRedisProperties.class)
@ConditionalOnProperty(prefix = "spring.redis.embedded", name = "enabled", havingValue = "true")
public class EmbeddedRedisAutoConfiguration {

    private final EmbeddedRedisProperties properties;
    private RedisServer redisServer;

    public EmbeddedRedisAutoConfiguration(EmbeddedRedisProperties properties) {
        this.properties = properties;
    }

    @Bean("embeddedRedisServer")
    public RedisServer startRedis() throws IOException {
        redisServer = new RedisServerBuilder()
                .port(properties.getPort())
                // embedded-redis 在 Windows 下启动 Redis 时，会默认使用一个比较大的 heap（内存映射文件） 来支持持久化（fork 子进程）。Windows 要求这个内存区域必须是连续的。
                // 修复 系统页面文件中没有足够的连续空间 分配给 Redis 的 heap，所以 Redis 启动失败。
                .setting("maxheap 128mb")
                .build();
        redisServer.start();
        System.out.println("✅ Embedded Redis started on port " + properties.getPort());
        return redisServer;
    }

    @PreDestroy
    public void stopRedis() {
        if (redisServer != null) {
            redisServer.stop();
            System.out.println("✅ Embedded Redis stopped");
        }
    }
}