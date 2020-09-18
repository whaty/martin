package com.java2e.martin.common.data.util;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 狮少
 * @version 1.0
 * @date 2020/9/17
 * @describtion SpringContextHelper
 * @since 1.0
 */
@Component
@Lazy(false)
@Slf4j
public class SpringContextHelper implements ApplicationContextAware {

    public static ApplicationContext getApplicationContext() {
        if (APPLICATION_CONTEXT == null) {
            log.error("ApplicationContextAware未注入上下文信息");
        }
        return APPLICATION_CONTEXT;
    }

    /***
     * ApplicationContext上下文
     */
    private static ApplicationContext APPLICATION_CONTEXT = null;

    /**
     * Entity-对应的Service缓存
     */
    private static Map<String, IService> ENTITY_SERVICE_CACHE = new ConcurrentHashMap<>();
    /**
     * 存储主键字段非id的Entity
     */
    private static Map<String, String> PK_NID_ENTITY_CACHE = new ConcurrentHashMap<>();
    /**
     * 数据库类型
     */
    private static String DATABASE_TYPE = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (log.isDebugEnabled()) {
            log.debug("==== martin data 自动绑定上下文信息 ====");
        }
        APPLICATION_CONTEXT = applicationContext;
        ENTITY_SERVICE_CACHE.clear();
        PK_NID_ENTITY_CACHE.clear();
    }


    /***
     * 根据beanId获取Bean实例
     * @param beanId
     * @return
     */
    public static Object getBean(String beanId) {
        return getApplicationContext().getBean(beanId);
    }

    /***
     * 获取指定类型的单个Bean实例
     * @param clazz
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        try {
            return getApplicationContext().getBean(clazz);
        } catch (Exception e) {
            log.debug("无法找到 bean: {}", clazz.getSimpleName());
            return null;
        }
    }

    /***
     * 获取指定类型的全部实现类
     * @param type
     * @param <T>
     * @return
     */
    public static <T> List<T> getBeans(Class<T> type) {
        Map<String, T> map = getApplicationContext().getBeansOfType(type);
        if (CollUtil.isEmpty(map)) {
            return null;
        }
        List<T> beanList = new ArrayList<>();
        beanList.addAll(map.values());
        return beanList;
    }

    /***
     * 根据注解获取beans
     * @param annotationType
     * @return
     */
    public static List<Object> getBeansByAnnotation(Class<? extends Annotation> annotationType) {
        Map<String, Object> map = getApplicationContext().getBeansWithAnnotation(annotationType);
        if (CollUtil.isEmpty(map)) {
            return null;
        }
        List<Object> beanList = new ArrayList<>();
        beanList.addAll(map.values());
        return beanList;
    }
}
