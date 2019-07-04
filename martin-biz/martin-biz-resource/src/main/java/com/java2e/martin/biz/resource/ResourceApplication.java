package com.java2e.martin.biz.resource;

import com.java2e.martin.common.security.annotation.EnableMartinResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/5/17 15:55
 * @Describtion: ResourceApplication
 */
@SpringBootApplication
@EnableMartinResourceServer
public class ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }
}
