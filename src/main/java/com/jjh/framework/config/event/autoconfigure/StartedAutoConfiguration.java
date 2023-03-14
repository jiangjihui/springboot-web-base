package com.jjh.framework.config.event.autoconfigure;

import cn.hutool.core.date.DateUtil;
import com.jjh.framework.config.condition.HelpConditional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

/**
 * StartedAutoConfiguration
 *
 * @author jiangjihui
 * @date 2022/10/09
 **/
@Configuration
@Conditional(HelpConditional.class)
@ConditionalOnClass(WebServerInitializedEvent.class)
public class StartedAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(StartedAutoConfiguration.class);


    @Order(Ordered.HIGHEST_PRECEDENCE)
    @EventListener(WebServerInitializedEvent.class)
    public void afterStart(WebServerInitializedEvent event){
        System.setProperty("app.startup.time", DateUtil.now());
        Environment env = event.getApplicationContext().getEnvironment();
        System.setProperty("app.startup.env", StringUtils.arrayToCommaDelimitedString(env.getActiveProfiles()));
    }


}
