package com.jjh.framework.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
* @author  jiangjihui
*  @date 2023/3/14
**/
@Component
@ConfigurationProperties(prefix = "app.config.help")
public class AppHelpProperties {

    /** 是否启用*/
    private static Boolean enabled;
    /** 版本*/
    private static String auth;

    public static Boolean getEnabled() {
        return enabled;
    }

    public static String getAuth() {
        return auth;
    }

    public void setEnabled(Boolean enabled) {
        AppHelpProperties.enabled = enabled;
    }

    public void setAuth(String auth) {
        AppHelpProperties.auth = auth;
    }
}
