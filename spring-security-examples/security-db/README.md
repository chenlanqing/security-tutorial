文章列表：
- [Spring Security用户数据存入数据库](http://www.javaboy.org/2020/0409/spring-security-JdbcUserDetailsManager.html)

Spring Security 用户存入数据库
-- 

### 1、UserDetailService

Spring Security 支持多种不同的数据源，这些不同的数据源最终都将被封装成 UserDetailsService 的实例，
除了 InMemoryUserDetailsManager 之外，还有一个 JdbcUserDetailsManager，使用 JdbcUserDetailsManager 可以让我们通过 JDBC 的方式将数据库和 Spring Security 连接起来

### 2、JdbcUserDetailsManager

JdbcUserDetailsManager 自己提供了一个数据库模型，这个数据库模型保存在如下位置：
```
org/springframework/security/core/userdetails/jdbc/users.ddl
```
脚本如下：
```hsqldb
create table users(username varchar_ignorecase(50) not null primary key,password varchar_ignorecase(500) not null,enabled boolean not null);
create table authorities (username varchar_ignorecase(50) not null,authority varchar_ignorecase(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);
```
脚本中有一种数据类型 varchar_ignorecase，这个其实是针对 HSQLDB 数据库创建的，而我们使用的 MySQL 并不支持这种数据类型，调整后脚本: [mysql.sql](db/mysql.sql)
,