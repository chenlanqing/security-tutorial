[Spring Security入门](http://www.javaboy.org/2020/0325/spring-security-form-login.html)

本示例项目包含如下功能点：
### 1、基本使用

默认情况下，账号是：user，密码是通过UUID生成的，应用启动时会在控制台打印出来：
```
Using generated security password: 9ca2cdea-61ab-4914-9aef-940cbf5de9a7
```
相关配置类参考：[UserDetailsServiceAutoConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/security/servlet/UserDetailsServiceAutoConfiguration.html)

### 2、配置设置

```properties
spring.security.user.name=java
spring.security.user.password=123
```

### 3、代码设置账号、密码

代码配置参考：[SecurityConfig](src/main/java/com/qing/fan/config/SecurityConfig.java)

- 通过 AuthenticationManagerBuilder 设置 inMemoryAuthentication
```java
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("java")
                .password("123")
                .roles("admin");
    }
}
```

- 通过 UserDetailsService 来配置
```java
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin").password("123").roles("admin").build());
        manager.createUser(User.withUsername("user").password("123").roles("user").build());
        return manager;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }
}
```
