package com.java2e.com.martin.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/3/11
 * @describtion MartinCloudConfigApplication
 * @since 1.0
 */
@EnableConfigServer
@SpringBootApplication
public class MartinCloudConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(MartinCloudConfigApplication.class, args);
    }
}
