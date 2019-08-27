package com.java2e.martin.common.security;

import cn.hutool.core.convert.Convert;
import com.java2e.martin.common.security.component.PermitAllUrlProperties;
import com.java2e.martin.common.security.component.RemoteTokenServiceProperties;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/5/29 11:13
 * @Describtion: 自动配置Martin安全服务
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({PermitAllUrlProperties.class, RemoteTokenServiceProperties.class})
@ConditionalOnProperty(
        prefix = "martin.resource-server",
        name = {"enabled"},
        havingValue = "true",
        matchIfMissing = true
)
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MartinSercurityAutoConfiguration extends ResourceServerConfigurerAdapter {
    @Autowired
    private PermitAllUrlProperties permitAllUrlProperties;
    @Autowired
    private RemoteTokenServiceProperties remoteTokenServiceProperties;


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
        registry.anyRequest().authenticated()
                .and().csrf().disable();
    }


    /**
     * ResourceServerSecurityConfigurer 可以配置多种 token 校验方式，本例用的url认证，还可以基于 redis 实现,默认不配置的话，是基于内存认证
     * 基于redis实现，需要在本模块引入redis的jar包感觉太重了，所以采用的url认证
     * url认证必须配置以下几项：   checkTokenEndpointUrl;  clientId; clientSecret;
     *
     * @param resources
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        OAuth2ClientProperties oAuth2ClientProperties = remoteTokenServiceProperties.getOAuth2ClientProperties();
        log.info("oAuth2ClientProperties===============",Convert.toStr(oAuth2ClientProperties));
        ResourceServerProperties resourceServerProperties = remoteTokenServiceProperties.getResourceServerProperties();
        log.info("resourceServerProperties===============",Convert.toStr(resourceServerProperties));
        remoteTokenServices.setCheckTokenEndpointUrl(resourceServerProperties.getTokenInfoUri());
        remoteTokenServices.setClientId(oAuth2ClientProperties.getClientId());
        remoteTokenServices.setClientSecret(oAuth2ClientProperties.getClientSecret());
        resources.tokenServices(remoteTokenServices);
    }
}
