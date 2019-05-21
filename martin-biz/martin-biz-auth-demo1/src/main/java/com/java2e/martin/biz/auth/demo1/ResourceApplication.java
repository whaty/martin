package com.java2e.martin.biz.auth.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author: liangcan
 * @version: 1.0
 * @date: 2019/5/17 15:55
 * @describtion: ResourceApplication
 */
@SpringBootApplication
@EnableResourceServer
public class ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }
}
