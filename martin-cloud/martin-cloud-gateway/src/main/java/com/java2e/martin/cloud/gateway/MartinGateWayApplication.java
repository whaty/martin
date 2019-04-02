package com.java2e.martin.cloud.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liangcan
 * @version: 1.0
 * @date: 2019/3/11
 * @describtion: MartinGateWayApplication
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class MartinGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(MartinGateWayApplication.class, args);
    }

    @Value("${foot}")
    private String profile;

    @GetMapping("/foot")
    public String hello() {
        return this.profile;
    }
}