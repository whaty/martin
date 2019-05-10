package com.java2e.martin.biz.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liangcan
 * @version: 1.0
 * @date: 2019/5/6
 * @describtion: MartinBizAuthApplication
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAuthorizationServer
@RestController
public class MartinBizAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(MartinBizAuthApplication.class, args);
    }

    @GetMapping("/g")
    public String getSt() {
        return "1323";
    }


}