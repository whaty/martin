package com.java2e.martin.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: liangcan
 * @version: 1.0
 * @date: 2019/3/8
 * @describtion: MartinEurekaApplication
 */
@EnableEurekaServer
@SpringBootApplication
public class MartinEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MartinEurekaApplication.class, args);
    }
}
