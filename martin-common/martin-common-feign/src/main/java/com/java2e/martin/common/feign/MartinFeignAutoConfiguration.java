package com.java2e.martin.common.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/7/30
 * @Describtion: 自动配置Martin内部通信服务
 */
@Slf4j
@Configuration
@ConditionalOnProperty(
        prefix = "martin.feign",
        name = {"enabled"},
        havingValue = "true",
        matchIfMissing = true
)
@EnableFeignClients(basePackages = {"com.java2e.martin.common.api"})
public class MartinFeignAutoConfiguration {
}
