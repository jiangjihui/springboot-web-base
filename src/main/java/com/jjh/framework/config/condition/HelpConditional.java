package com.jjh.framework.config.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * HelpConditional
 *
 * @author jiangjihui
 * @date 2022/10/09
 **/
public class HelpConditional implements Condition {

    private static final String HELP_ENABLED = "app.config.help.enabled";

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment env = conditionContext.getEnvironment();
        return env.getProperty(HELP_ENABLED, Boolean.class, true);
    }
}
