package com.java2e.martin.cloud.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/3/11
 * @Describtion: MartinGateWayApplication
 */
@SpringBootApplication
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
