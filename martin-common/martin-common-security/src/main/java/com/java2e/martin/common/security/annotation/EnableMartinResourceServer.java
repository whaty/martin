package com.java2e.martin.common.security.annotation;

import com.java2e.martin.common.security.MartinSercurityAutoConfiguration;
import com.java2e.martin.common.security.component.MartinResourceServerConfigurerAdapter;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/5/29 11:07
 * @Describtion: EnableMartinResourceServer
 */
@Documented
@Inherited
@EnableResourceServer
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({MartinSercurityAutoConfiguration.class, MartinResourceServerConfigurerAdapter.class})
public @interface EnableMartinResourceServer {
}
