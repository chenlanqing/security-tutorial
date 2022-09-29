文章参考：[SpringSecurity 自定义认证逻辑](http://www.javaboy.org/2020/0503/custom-authentication.html)

SpringSecurity 自定义认证逻辑
--

Spring Security 自定义认证有两种玩法：
- 一种是通过 自定义Filter来实现，并把这个Filter放到Spring Security的过滤器链上，那么每次请求都会通过该过滤器，这样可能会对性能有一定影响；
- 如果使用的账号和密码登录，那么都会走到： DaoAuthenticationProvider#additionalAuthenticationChecks 这个方法；

本工程使用的是第二种方法