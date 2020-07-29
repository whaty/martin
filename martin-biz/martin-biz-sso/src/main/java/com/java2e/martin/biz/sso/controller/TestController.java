package com.java2e.martin.biz.sso.controller;

import com.java2e.martin.common.api.resource.RemoteResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/5/20 11:10
 * @describtion TestController
 * @since 1.0
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
