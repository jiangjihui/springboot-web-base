package com.jjh.framework.aspect.sensitive;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 通过注解实现接口返回数据脱敏实现
 * https://juejin.cn/post/7110110794188062727
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataMasking {
    DataMaskingFunc maskFunc() default DataMaskingFunc.NO_MARK;
}
