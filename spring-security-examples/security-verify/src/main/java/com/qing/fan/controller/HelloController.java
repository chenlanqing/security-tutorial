package com.qing.fan.controller;

import com.qing.fan.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author QingFan 2022/9/29
 * @version 1.0.0
 */
@RestController
public class HelloController {

    @Resource
    HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        helloService.hello();
        return "hello";
    }
}
