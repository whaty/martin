package com.java2e.martin.biz.sso.controller;

import com.java2e.martin.common.api.resource.RemoteResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/5/20 11:10
 * @Describtion: TestController
 */
@RestController
@RequestMapping("client")
public class TestController {
    @Autowired
    public RemoteResource remoteResource;

    @GetMapping("/test")
    public String test() {
        System.out.println("remoteResource ========={} " + remoteResource.test());
        return "sso-client";
    }

    @GetMapping("/index")
    public String index() {
        return "sso-index";
    }
}