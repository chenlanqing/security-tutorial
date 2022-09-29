文章列表：
- [Spring Security授权操作](http://www.javaboy.org/2020/0325/spring-security-form-login.html)

Spring Security 如何授权
-- 

### 1、配置用户

配置两个用户：admin、user，其中用户 admin 拥有的角色是 admin，用户 user 拥有的角色是 user；
```java
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
```

### 2、实现admin拥有user所有角色权限

上级可能具备下级的所有权限，如果使用角色继承，SecurityConfig 中添加如下代码来配置角色继承关系即可：
```java
/**
 * 配置角色继承：admin 拥有 user 的权限：
 */
@Bean
RoleHierarchy roleHierarchy() {
    RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
    hierarchy.setHierarchy("ROLE_admin > ROLE_user");
    return hierarchy;
}
```
在配置时，需要给角色手动加上 ROLE_ 前缀。上面的配置表示 ROLE_admin 自动具备 ROLE_user 的权限