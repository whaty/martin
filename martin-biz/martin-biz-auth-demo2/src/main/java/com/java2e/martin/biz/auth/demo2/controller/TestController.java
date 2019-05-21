package com.java2e.martin.biz.auth.demo2.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liangcan
 * @version: 1.0
 * @date: 2019/5/20 11:10
 * @describtion: TestController
 */
@RestController
@RequestMapping("client")
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "sso-client";
    }

    @GetMapping("/index")
    public String index() {
        return "sso-index";
    }
}
