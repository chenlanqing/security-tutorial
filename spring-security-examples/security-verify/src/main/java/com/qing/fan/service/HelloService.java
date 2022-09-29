package com.qing.fan.service;

import com.qing.fan.config.CustomWebAuthenticationDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author QingFan 2022/9/29
 * @version 1.0.0
 */
@Service
public class HelloService {

    public void hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) authentication.getDetails();
        System.out.println(details);
    }
}
