# SSM
> HolanSwide
>
> 这是一个简单的基础项目，采用 Spring + SpringMVC +Mybatis 架构搭建，服务器采用 tomcat，数据库使用的是 MySQL
>
> 版本：
> - Spring 5.2.5.RELEASE
> - SpringMVC 5.1.19
> - Mybatis 2.0.7
> - tomcat 8.5.73
> - MySQL 5.5

# 开发日志

## day1
> 2022年6月23日23点58分

- 搭建了基本SSM框架
- 搭建了数据库ssm，建立好了第一个表 user
- 创建了用户类 User
- 测试好了框架之间的协    同

## day2
> 2022年6月24日16点46分

- 完成登录和注册功能
- 问题：controller中添加事务注解时出现错误

## day03
> 2022年6月25日16点11分
                                    
- 采用Vue框架重构

## day04
> 2022年8月6日15点24分


- 如何使Controller返回数据而非页面
> 在对应方法体上添加注解`@ResponseBody`,
> 同时要在`@RequestMapping`注解中加入参数`produces={"application/json;charset=UTF-8"}`以防止乱码

- 拦截器添加满足条件的不拦截的站点

> 见 [spingmvc-config.xml](./src/main/resources/springmvc-config.xml) 和
> [LoginInterceptor.java](./src/main/java/com/holanswide/interceptor/LoginInterceptor.java) 

- 完成了注册登录功能的重构
- 写好了拦截器

# day05
> 2022年8月10日15点32分

- 使用Vue+Element-ui进行前端重构
- 增加数据表user_info记录用户信息

# day06
> 2022年8月11日23点22分

- 完成了登录-注册-修改密码功能