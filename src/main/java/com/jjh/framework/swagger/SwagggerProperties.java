package com.jjh.framework.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 接口信息
 *
 * @author jjh
 * @date 2021/03/11
 **/
@Data
@Component
@ConfigurationProperties(prefix = "app.swagger")
public class SwagggerProperties {

    /** 标题*/
    private static String title;
    /** 描述*/
    private static String description;
    /** 版本*/
    private static String version;


}
