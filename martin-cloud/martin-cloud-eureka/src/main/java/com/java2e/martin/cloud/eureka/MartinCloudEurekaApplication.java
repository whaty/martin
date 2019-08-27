package com.java2e.martin.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/3/8
 * @Describtion: MartinCloudEurekaApplication
 */
@EnableEurekaServer
@SpringBootApplication
public class MartinCloudEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MartinCloudEurekaApplication.class, args);
    }
}
