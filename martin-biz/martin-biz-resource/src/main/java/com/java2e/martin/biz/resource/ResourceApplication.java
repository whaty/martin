package com.java2e.martin.biz.resource;

import cn.hutool.core.convert.Convert;
import com.java2e.martin.biz.resource.component.PermitAllUrlPropertiesTest;
import com.java2e.martin.common.security.annotation.EnableMartinResourceServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/5/17 15:55
 * @Describtion: ResourceApplication
 */
@SpringBootApplication
@EnableMartinResourceServer
public class ResourceApplication implements CommandLineRunner {


    @Autowired
    private PermitAllUrlPropertiesTest permitAllUrlPropertiesTest;

    public static void main(String[] args) {

        SpringApplication.run(ResourceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("permitAllUrlProperties.getIgnoreUrls = " + Convert.toStr(permitAllUrlPropertiesTest.getIgnoreUrls()));
        System.out.println("permitAllUrlPropertiesTest.getScope = " + permitAllUrlPropertiesTest.getScope());
    }
}
