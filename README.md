# martin
spring cloud微服务，开箱即用

----

项目端口规划

--> Martin

----> Martin-eureka: 9000 (注册中心)

----> Martin-config: 9100 （配置中心）

----> Martin-gateway: 9200 （网关）

----> Martin-auth: 9300  （oauth2.0 认证中心）

----> Martin-biz: 94**  （各种资源服务）

--------> Martin-biz: 9401  （示例资源服务）

--------> Martin-biz: 9402  （示例sso服务）

----



|功能|开源版 |升级版|商业版|
|--|--|--|--|
完整源码，永久更新                   | √ | √ |√ |
Spring Boot 2.1.x                    | √ | √ |√ |
Spring Cloud Greenwich               | √ | √ |√ |
Spring Cloud Gateway                 | √ | √ |√ |
MyBatis Plus 3.1.x                   | √ | √ |√ |
前后端代码生成                       | √ | √ |√ |
分布式事务解决方案                   | × | √ |√ |
Activiti 工作流                      | × | √ |√ |
微信公众号管理                       | × | √ |√ |
SAAS 多租户                          | × | √ |√ |
SSO单点登录                          | × | √ |√ |
oauth2多方式登录                     | × | √ |√ |
服务端动态路由                       | × | √ |√ |
聚合swagger文档                      | × | √ |√ |
图形化定时任务、数据权限             | × | √ |√ |
Websocket                            | × | √ |√ |
组件starter 、bom模块化              | × | √ |√ |
Minio 文件系统                       | × | √ |√ |
Feign自动降级                        | × | √ |√ |
IE 浏览器、多终端适配                | × | √ |√ |
菜单搜索、无限层级路由缓冲           | × | √ |√ |
git私服                              | × | √ |√ |
VIP 售后群                           | × | √ |√ |
商业使用                             | × | × |√ |

