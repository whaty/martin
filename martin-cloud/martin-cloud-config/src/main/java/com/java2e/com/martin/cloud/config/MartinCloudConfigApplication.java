package com.java2e.com.martin.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/3/11
 * @Describtion: MartinCloudConfigApplication
 */
@EnableConfigServer
@SpringBootApplication
public class MartinCloudConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(MartinCloudConfigApplication.class, args);
    }
}
