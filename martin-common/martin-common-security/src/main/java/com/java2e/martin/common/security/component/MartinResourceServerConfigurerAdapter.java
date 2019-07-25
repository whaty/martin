package com.java2e.martin.common.security.component;

import cn.hutool.core.convert.Convert;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/5/28 15:47
 * @Describtion: MartinResourceServerConfigurerAdapter
 */
@Slf4j
public class MartinResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {
    @Autowired
    private PermitAllUrlProperties permitAllUrlProperties;


    /**
     * 默认的配置，对外暴露
     *
     * @param httpSecurity
     */
    @Override
    @SneakyThrows
    public void configure(HttpSecurity httpSecurity) {
        //允许使用iframe 嵌套，避免swagger-ui 不被加载的问题
        httpSecurity.headers().frameOptions().disable();
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>
                .ExpressionInterceptUrlRegistry registry = httpSecurity
                .authorizeRequests();
        log.info(Convert.toStr("permitAllUrlProperties : " + permitAllUrlProperties.getIgnoreUrls()));
        permitAllUrlProperties.getIgnoreUrls()
                .forEach(url -> registry.antMatchers(url).permitAll());
        registry.antMatchers("/test").permitAll();
        registry.anyRequest().authenticated()
                .and().csrf().disable();
    }

}
