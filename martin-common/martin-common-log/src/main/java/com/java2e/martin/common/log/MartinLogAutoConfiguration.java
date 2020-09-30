package com.java2e.martin.common.log;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/8/22
 * @describtion M自动配置日志服务
 * @since 1.0
 */
@Slf4j
@Configuration
@EnableAsync
@AllArgsConstructor
@ConditionalOnWebApplication
@ConditionalOnProperty(
        prefix = "martin.log",
        name = {"enabled"},
        havingValue = "true",
        matchIfMissing = true
)
@ComponentScan(basePackages = {"com.java2e.martin.common.log", "com.java2e.martin.common.core"})
public class MartinLogAutoConfiguration {
}
