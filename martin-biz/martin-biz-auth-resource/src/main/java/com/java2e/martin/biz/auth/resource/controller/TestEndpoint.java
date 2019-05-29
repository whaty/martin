package com.java2e.martin.biz.auth.resource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/5/17 16:03
 * @Describtion: TestEndpoint
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

