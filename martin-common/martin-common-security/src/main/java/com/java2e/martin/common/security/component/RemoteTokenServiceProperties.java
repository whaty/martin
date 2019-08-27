package com.java2e.martin.common.security.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/8/27
 * @Describtion: RemoteTokenServiceProperties
 */
@Data
@AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "security.oauth2")
public class RemoteTokenServiceProperties {
    private final ResourceServerProperties resourceServerProperties;
    private final OAuth2ClientProperties oAuth2ClientProperties;

}
