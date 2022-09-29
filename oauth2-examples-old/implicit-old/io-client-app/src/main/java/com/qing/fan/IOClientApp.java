package com.qing.fan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author QingFan 2022/9/28
 * @version 1.0.0
 */
@SpringBootApplication
public class IOClientApp {

    public static void main(String[] args) {
        SpringApplication.run(IOClientApp.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
