package com.java2e.martin.common.security.interceptor;

import cn.hutool.core.collection.CollectionUtil;
import com.java2e.martin.common.core.api.ApiErrorCode;
import com.java2e.martin.common.core.api.R;
import com.java2e.martin.common.core.constant.SecurityConstants;
import com.java2e.martin.common.feign.remote.RemoteUrl;
import com.java2e.martin.common.security.component.PermitAllUrlProperties;
import com.java2e.martin.common.security.component.RemoteTokenServiceProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/9/4
 * @Describtion: FeignInnerInterceptor, controller前置拦截器，校验内部feign调用秘钥
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({PermitAllUrlProperties.class})
public class FeignInnerInterceptor extends HandlerInterceptorAdapter {
    @Value("${martin.feign.secret:123456}")
    private String secret;

    @Autowired
    private PermitAllUrlProperties permitAllUrlProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<String> ignoreUrls = permitAllUrlProperties.getIgnoreUrls();
        Set<String> feignUrls = RemoteUrl.REMOTE_URLS;
        //内部feign调用名单为空，则放行
        if (CollectionUtil.isEmpty(feignUrls)) {
            return true;
        }
        String uri = request.getRequestURI();
        log.debug("current url : {}", uri);
        //判断是否只允许内部服务调用
        boolean isInner = feignUrls.stream().anyMatch(url -> {
            AntPathMatcher matcher = new AntPathMatcher();
            boolean isOuter = ignoreUrls.stream().anyMatch(u -> {
                log.debug("permit outer url : {}", u);
                return matcher.match(u, uri);
            });
            log.debug("current url match permit outer  url : {}", isOuter);
            //允许外部访问
            if (isOuter) {
                return false;
            }
            //是否只允许内部调用
            return matcher.match(url, uri);
        });
        //不包含在feign内部调用名单，则放行
        if (!isInner) {
            return true;
        }
        String martinInner = request.getHeader(SecurityConstants.MARTIN_INNER);
        log.debug("martin-inner secret:{}", martinInner);
        if (null == martinInner || !martinInner.equals(secret)) {
            log.error("{}", R.failed(ApiErrorCode.FORBIDEN));
            response.sendError(403);
            return false;
        } else {
            return true;
        }
    }

}
