package com.java2e.martin.common.security.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/9/4
 * @Describtion: FeignSecretProperties
 */
@Configuration
@RefreshScope
public class FeignSecretProperties {
    @Value("${martin.feign.secret:123456}")
    private String secret;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
