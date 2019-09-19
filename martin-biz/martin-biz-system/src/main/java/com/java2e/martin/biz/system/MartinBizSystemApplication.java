package com.java2e.martin.biz.system;

import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/8/14
 * @Describtion: Martin 核心系统
 */
@SpringBootApplication
@MapperScan("com.java2e.martin.biz.system.mapper")
public class MartinBizSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(MartinBizSystemApplication.class, args);
    }

    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //格式化sql语句
        Properties properties = new Properties();
        properties.setProperty("format", "false");
        performanceInterceptor.setProperties(properties);
        return performanceInterceptor;
    }
}
