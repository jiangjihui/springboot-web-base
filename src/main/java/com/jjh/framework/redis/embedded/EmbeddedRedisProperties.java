package com.jjh.framework.redis.embedded;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.redis.embedded")
public class EmbeddedRedisProperties {

    /**
     * 是否启用嵌入式 Redis
     */
    private boolean enabled = false;

    /**
     * Redis 端口
     */
    private int port = 6379;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}