package com.java2e.martin.biz.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: liangcan
 * @version: 1.0
 * @date: 2019/5/20 16:31
 * @describtion: LoginController
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("views/login");
    }
}
