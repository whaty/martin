package com.java2e.martin.biz.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liangcan
 * @version: 1.0
 * @date: 2019/3/12
 * @describtion: MartinBizHelloApplication
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class MartinBizHelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(MartinBizHelloApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }


}
