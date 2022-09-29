文章列表：
- [Spring Security自定义登录表单](http://www.javaboy.org/2020/0325/spring-security-form-login.html)
- [Spring Security定制表单登录](http://www.javaboy.org/2020/0330/spring-security-custom-formlogin.html)

自定义表单登录以及登录成功之后回调配置
--

### 登录成功跳转

在 Spring Security 中，和登录成功重定向 URL 相关的方法有两个：
- defaultSuccessUrl: 分为两种情况
  - 只有一个参数的 defaultSuccessUrl 方法:如果在 defaultSuccessUrl 中指定登录成功的跳转页面为 /index，此时分两种情况，如果你是直接在浏览器中输入的登录地址，登录成功后，就直接跳转到 /index，如果你是在浏览器中输入了其他地址
  - 第二个参数如果不设置默认为 false，也就是上面的的情况，如果手动设置第二个参数为 true，则 defaultSuccessUrl 的效果和 successForwardUrl 一致
- successForwardUrl: 表示不管你是从哪里来的，登录后一律跳转到 successForwardUrl 指定的地址