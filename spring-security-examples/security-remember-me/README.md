文章列表：
- [Spring Security自动登录风险控制](http://www.javaboy.org/2020/0429/rememberme-advance.html)

自动登录风险控制
-- 

### 1、开启自动登录

```java
@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .rememberMe()
            .and()
            .csrf().disable();
}
```
