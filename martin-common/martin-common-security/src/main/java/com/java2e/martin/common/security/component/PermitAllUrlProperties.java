package com.java2e.martin.common.security.component;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/5/22 11:09
 * @describtion PermitAllUrlProperties
 * 模块对外开放的url集合
 * @since 1.0
 */
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "security.oauth2.client")
public class PermitAllUrlProperties {
    private List<String> ignoreUrls = new ArrayList<>();

    public List<String> getIgnoreUrls() {
        return ignoreUrls;
    }

    @ConditionalOnExpression("!'${security.oauth2.client.ignore-urls}'.isEmpty()")
    public void setIgnoreUrls(List<String> ignoreUrls) {
        this.ignoreUrls = ignoreUrls;
    }
}
