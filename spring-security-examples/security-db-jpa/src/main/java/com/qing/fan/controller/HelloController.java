package com.qing.fan.controller;

import com.qing.fan.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QingFan 2022/9/26
 * @version 1.0.0
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user.toString();
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
