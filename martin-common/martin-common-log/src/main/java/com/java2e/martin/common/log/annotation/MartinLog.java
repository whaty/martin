package com.java2e.martin.common.log.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/8/22
 * @Describtion: MartinLog 日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MartinLog {

    /**
     * 日志名称
     *
     * @return {String}
     */
    String value();
}
