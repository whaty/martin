package com.java2e.martin.biz.sso.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/5/20 11:41
 * @Describtion: WebSecurityConfigurer
 */
@EnableOAuth2Sso
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/client/index")
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}

