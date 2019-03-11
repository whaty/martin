package com.java2e.com.martin.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author: liangcan
 * @version: 1.0
 * @date: 2019/3/11
 * @describtion: MartinConfigApplication
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class MartinConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(MartinConfigApplication.class, args);
    }
}
