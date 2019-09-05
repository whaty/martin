package com.java2e.martin.biz.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
}