package com.java2e.martin.biz.resource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/5/17 16:03
 * @describtion TestEndpoint
 * @since 1.0
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

