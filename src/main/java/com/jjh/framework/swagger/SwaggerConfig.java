package com.jjh.framework.swagger;

import cn.hutool.core.util.RandomUtil;
import com.jjh.framework.jwt.JWTConstants;
import com.jjh.framework.properties.ApplicationInfoProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Swagger2API文档的配置
 *
 * @author jjh
 * @date 2019/10/30
 **/
@Configuration
@EnableAutoConfiguration
// @ConditionalOnBean(SwagggerProperties.class)
// @EnableConfigurationProperties(SwagggerProperties.class)
public class SwaggerConfig {

    /** 用户配置 */
    // private final SwagggerProperties properties;


    /**
     * 根据@Tag 上的排序，写入x-order
     *
     * @return the global open api customizer
     */
    @Bean
    public GlobalOpenApiCustomizer orderGlobalOpenApiCustomizer() {
        return openApi -> {
            if (openApi.getTags()!=null){
                openApi.getTags().forEach(tag -> {
                    Map<String,Object> map=new HashMap<>();
                    map.put("x-order", RandomUtil.randomInt(0,100));
                    tag.setExtensions(map);
                });
            }
            if(openApi.getPaths()!=null){
                openApi.addExtension("x-test123","333");
                openApi.getPaths().addExtension("x-abb",RandomUtil.randomInt(1,100));
            }
        };
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(JWTConstants.X_ACCESS_TOKEN))
                .info(new Info()
                        .title(ApplicationInfoProperties.getApiTitle())
                        .version(ApplicationInfoProperties.getVersion())
                        .description(ApplicationInfoProperties.getDescription())
                        .summary(ApplicationInfoProperties.getContact())
                        .termsOfService("http://doc.xiaominfo.com")
                        .license(new License().name("Apache 2.0")
                                .url("http://doc.xiaominfo.com")));
    }

}
