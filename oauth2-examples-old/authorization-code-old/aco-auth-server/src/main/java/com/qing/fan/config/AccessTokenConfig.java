package com.qing.fan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @author QingFan 2022/9/27
 * @version 1.0.0
 */
@Configuration
public class AccessTokenConfig {

    /**
     * 生成的 Token 要往哪里存储，本案例是放在内存中的
     */
    @Bean
    TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
}
