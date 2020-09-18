package com.java2e.martin.common.security.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.java2e.martin.common.core.constant.CommonConstants;
import com.java2e.martin.common.security.util.SecurityContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/11/1
 * @describtion MybatisPlusConfiguration
 * @since 1.0
 */
@Configuration
@Slf4j
public class MybatisPlusConfiguration implements MetaObjectHandler {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.setInsertFieldValByName(CommonConstants.CREATOR, SecurityContextUtil.getUser().getId(), metaObject);
        this.setInsertFieldValByName(CommonConstants.CREATE_TIME, LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.setUpdateFieldValByName(CommonConstants.UPDATER, SecurityContextUtil.getUser().getId(), metaObject);
        this.setUpdateFieldValByName(CommonConstants.UPDATE_TIME, LocalDateTime.now(), metaObject);
    }
}
