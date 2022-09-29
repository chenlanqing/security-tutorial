文章列表：
- [Spring Security使用JSON格式登录](http://www.javaboy.org/2020/0331/spring-security-json.html)

在前后端分离的情况下，使用JSON格式登录
--

Spring Security 中默认的登录数据格式就是 key/value 的形式，其处理逻辑是在 UsernamePasswordAuthenticationFilter 类中的，要定义成 JSON 的，思路很简单，就是自定义来定义一个过滤器代替 UsernamePasswordAuthenticationFilter ，然后在获取参数的时候，换一种方式就行了