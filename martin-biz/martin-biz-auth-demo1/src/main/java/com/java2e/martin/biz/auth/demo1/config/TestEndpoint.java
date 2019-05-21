package com.java2e.martin.biz.auth.demo1.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liangcan
 * @version: 1.0
 * @date: 2019/5/17 16:03
 * @describtion: TestEndpoint
 */
@RestController
public class TestEndpoint {
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/test1")
    public String test1() {
        return "test1";
    }
}

