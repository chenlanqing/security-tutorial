package com.qing.fan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author QingFan 2022/9/26
 * @version 1.0.0
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /**
     * 具有 admin 身份的人才能访问的接口
     */
    @GetMapping("/admin/hello")
    public String admin() {
        return "admin";
    }

    /**
     * 具有 user 身份的人才能访问的接口，
     * 所有 user 能够访问的资源，admin 都能够访问
     */
    @GetMapping("/user/hello")
    public String user() {
        return "user";
    }
}
