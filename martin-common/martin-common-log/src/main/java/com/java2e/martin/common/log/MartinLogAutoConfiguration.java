package com.java2e.martin.common.log;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/8/22
 * @Describtion: M自动配置日志服务
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
public class MartinLogAutoConfiguration {

}
