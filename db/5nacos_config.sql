/******************************************/
/*   数据库全名 = nacos_config   */
/*   表名称 = config_info   */
/******************************************/

USE nacos_config;

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `config_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) DEFAULT NULL,
  `content` longtext NOT NULL COMMENT 'content',
  `md5` varchar(32) DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '修改时间',
  `src_user` text COMMENT 'source user',
  `src_ip` varchar(20) DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) DEFAULT NULL,
  `tenant_id` varchar(128) DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) DEFAULT NULL,
  `c_use` varchar(64) DEFAULT NULL,
  `effect` varchar(64) DEFAULT NULL,
  `type` varchar(64) DEFAULT NULL,
  `c_schema` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfo_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info';


INSERT INTO `nacos_config`.`config_info` (`id`, `data_id`, `group_id`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `app_name`, `tenant_id`, `c_desc`, `c_use`, `effect`, `type`, `c_schema`) VALUES ('27', 'application-dev.yml', 'DEFAULT_GROUP', 'foot: foot-dev4', 'b8cf7a9dbe1343ef35ebac9fb0af6e34', '2019-11-06 17:39:10', '2019-11-07 14:45:04', NULL, '127.0.0.1', '', '', 'null', 'null', 'null', 'yaml', 'null');
INSERT INTO `nacos_config`.`config_info` (`id`, `data_id`, `group_id`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `app_name`, `tenant_id`, `c_desc`, `c_use`, `effect`, `type`, `c_schema`) VALUES ('28', 'application.yml', 'DEFAULT_GROUP', 'spring:\r\n  profiles:\r\n    active: dev\r\n\r\n  # 数据源\r\n  datasource:\r\n    url: jdbc:mysql://martin-mysql:3306/martin?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8\r\n    type: com.zaxxer.hikari.HikariDataSource\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n    username: root\r\n    password: root\r\n    #验证连接的有效性\r\n    test-while-idle: true\r\n    #空闲连接回收的时间间隔，与test-while-idle一起使用，设置5分钟\r\n    time-between-eviction-runs-millis: 300000\r\n    #连接池空闲连接的有效时间 ，设置30分钟\r\n    min-evictable-idle-time-millis: 1800000\r\n    #获取连接时候验证\r\n    test-on-borrow: true\r\n    # 配置监控统计拦截的filters，去掉后监控界面sql无法统计，\'wall\'用于防火墙\r\n    filters: stat,wall,slf4j\r\n    hikari:\r\n      ## 最小空闲连接数量\r\n      minimum-idle: 5\r\n      ## 空闲连接存活最大时间，默认600000（10分钟）\r\n      idle-timeout: 180000\r\n      ## 连接池最大连接数，默认是10\r\n      maximum-pool-size: 20\r\n      ## 此属性控制从池返回的连接的默认自动提交行为,默认值：true\r\n      auto-commit: true\r\n      ## 连接池母子\r\n      pool-name: MyHikariCP\r\n      ## 此属性控制池中连接的最长生命周期，值0表示无限生命周期，默认1800000即30分钟\r\n      max-lifetime: 1800000\r\n      ## 数据库连接超时时间,默认30秒，即30000\r\n      connection-timeout: 60000\r\n      connection-test-query: SELECT 1\r\n      #connection-test-query: select 1 from dual\r\n\r\nfoot: foot\r\n\r\nauth-server: http://localhost:9400\r\n\r\n#本项目用一个资源配置，将来可为每个服务单独配置oauth信息\r\nsecurity:\r\n  oauth2:\r\n    client:\r\n      client-id: client2 # 授权服务器配置的client id\r\n      client-secret: 123456 # 授权服务器配置的client secret\r\n      scope: all\r\n      #access-token-uri: ${auth-server}/oauth/token # 获取access token接口\r\n      #user-authorization-uri: ${auth-server}/oauth/authorize #  获取Authorization Code接口\r\n    resource:\r\n      token-info-uri: ${auth-server}/oauth/check_token # 验证token的接口\r\n#      user-info-uri: ${auth-server}/user # 一个可以获取认证授权的自定义接口，可以在授权服务器，也可以在其他服务器上\r\n#      prefer-token-info: true # 如果同时配置了token-info-uri 和 user-info-uri，这个现象设置使用哪个取验证授权\r\n\r\n\r\nmybatis-plus:\r\n  # 如果是放在src/main/java目录下 classpath:/com/yourpackage/*/mapper/*Mapper.xml\r\n  # 如果是放在resource目录 classpath:/mapper/*Mapper.xml\r\n  mapper-locations: classpath:/mapper/**/*Mapper.xml\r\n  #实体扫描，多个package用逗号或者分号分隔\r\n  typeAliasesPackage: com.java2e.martin.*.entity\r\n  global-config:\r\n    #主键类型  0:\"数据库ID自增\", 1:\"用户输入ID\",2:\"全局唯一ID (数字类型唯一ID)\", 3:\"全局唯一ID UUID\";\r\n    id-type: 3\r\n    #字段策略 0:\"忽略判断\",1:\"非 NULL 判断\"),2:\"非空判断\"\r\n    field-strategy: 2\r\n    #驼峰下划线转换\r\n    db-column-underline: true\r\n    #mp2.3+ 全局表前缀 mp_\r\n    #table-prefix: mp_\r\n    #刷新mapper 调试神器\r\n    refresh-mapper: true\r\n    #数据库大写下划线转换\r\n    #capital-mode: true\r\n    # Sequence序列接口实现类配置,oracle用\r\n    #key-generator: com.baomidou.mybatisplus.incrementer.OracleKeyGenerator\r\n    #逻辑删除配置（下面3个配置）\r\n    logic-delete-value: 1\r\n    logic-not-delete-value: 0\r\n    #sql-injector: com.baomidou.mybatisplus.mapper.LogicSqlInjector\r\n    #自定义填充策略接口实现\r\n    #meta-object-handler: com.baomidou.springboot.MyMetaObjectHandler\r\n  configuration:\r\n    #配置返回数据库(column下划线命名&&返回java实体是驼峰命名)，自动匹配无需as（没开启这个，SQL需要写as： select user_id as userId）\r\n    map-underscore-to-camel-case: true\r\n    cache-enabled: false\r\n    #配置JdbcTypeForNull, oracle数据库必须配置\r\n    jdbc-type-for-null: \'null\'\r\n    lazyLoadingEnabled: true #延时加载的开关\r\n    multipleResultSetsEnabled: true #开启的话，延时加载一个属性时会加载该对象全部属性，否则按需加载属性\r\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl #打印sql语句,调试用\r\n\r\n#swagger公共信息\r\nswagger:\r\n  host: localhost:9502\r\n  title: Amap Swagger API\r\n  description: Martin 聚合文档\r\n  version: 2.0\r\n  license: Powered By java2e\r\n  licenseUrl: http://java2e.com/\r\n  terms-of-service-url: http://java2e.com/\r\n  contact:\r\n    name: 梁灿\r\n    email: liangcan.jxjy.edu@gmail.com\r\n    url: https://java2e.com/about.html\r\n  authorization:\r\n    name: Martin OAuth\r\n    auth-regex: ^.*$\r\n    authorization-scope-list:\r\n      - scope: server\r\n        description: server all\r\n    token-url-list:\r\n      - ${security.auth.server}/token\r\n\r\nmartin:\r\n  swagger:\r\n    enabled: true\r\n  resource-server:\r\n    enabled: true\r\n  feign:\r\n    enabled: true\r\n    secret: 12345678\r\n', '5e5ba48775f595cc660bb47ac42a7821', '2019-11-06 17:39:10', '2019-11-07 15:05:33', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `nacos_config`.`config_info` (`id`, `data_id`, `group_id`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `app_name`, `tenant_id`, `c_desc`, `c_use`, `effect`, `type`, `c_schema`) VALUES ('29', 'martin-biz-auth-dev.yml', 'DEFAULT_GROUP', 'spring:\r\n  redis:\r\n    host: martin-redis\r\n    port: 6379\r\n    inetutils:\r\n      ignored-interfaces:\r\n        - docker0\r\n        - veth.*\r\n        - VM.*\r\n  freemarker:\r\n    template-loader-path: classpath:/templates/\r\n', '944ce614a83c195adaf09c2a6a6ac1ff', '2019-11-06 17:39:10', '2019-11-07 14:45:13', NULL, '127.0.0.1', '', '', 'null', 'null', 'null', 'yaml', 'null');
INSERT INTO `nacos_config`.`config_info` (`id`, `data_id`, `group_id`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `app_name`, `tenant_id`, `c_desc`, `c_use`, `effect`, `type`, `c_schema`) VALUES ('30', 'martin-biz-resource-dev.yml', 'DEFAULT_GROUP', 'security:\r\n  oauth2:\r\n    client:\r\n      client-id: client2 # 授权服务器配置的client id\r\n      client-secret: 123456 # 授权服务器配置的client secret\r\n      scope: select\r\n      ignore-urls:\r\n        - /test\r\n      #access-token-uri: ${auth-server}/oauth/token # 获取access token接口\r\n      #user-authorization-uri: ${auth-server}/oauth/authorize #  获取Authorization Code接口\r\n    resource:\r\n      token-info-uri: ${auth-server}/oauth/check_token # 验证token的接口\r\n#      user-info-uri: ${auth-server}/user # 一个可以获取认证授权的自定义接口，可以在授权服务器，也可以在其他服务器上\r\n#      prefer-token-info: true # 如果同时配置了token-info-uri 和 user-info-uri，这个现象设置使用哪个取验证授权\r\n', '7d45101c4808dc7ed6ddd4641df63ec3', '2019-11-06 17:39:10', '2019-11-07 14:45:32', NULL, '127.0.0.1', '', '', 'null', 'null', 'null', 'yaml', 'null');
INSERT INTO `nacos_config`.`config_info` (`id`, `data_id`, `group_id`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `app_name`, `tenant_id`, `c_desc`, `c_use`, `effect`, `type`, `c_schema`) VALUES ('31', 'martin-biz-sso-dev.yml', 'DEFAULT_GROUP', 'security:\r\n  oauth2:\r\n    client:\r\n      client-id: client3\r\n      client-secret: 123456\r\n      scope: sso\r\n      ignore-urls:\r\n        - /client/test\r\n      access-token-uri: ${auth-server}/oauth/token\r\n      user-authorization-uri: ${auth-server}/oauth/authorize\r\n    resource:\r\n      token-info-uri: ${auth-server}/oauth/check_token\r\n', 'b59efa193849683db54009ce2aafdb26', '2019-11-06 17:39:10', '2019-11-07 14:45:38', NULL, '127.0.0.1', '', '', 'null', 'null', 'null', 'yaml', 'null');
INSERT INTO `nacos_config`.`config_info` (`id`, `data_id`, `group_id`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `app_name`, `tenant_id`, `c_desc`, `c_use`, `effect`, `type`, `c_schema`) VALUES ('32', 'martin-biz-swagger-dev.yml', 'DEFAULT_GROUP', '', 'd41d8cd98f00b204e9800998ecf8427e', '2019-11-06 17:39:10', '2019-11-06 17:39:10', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `nacos_config`.`config_info` (`id`, `data_id`, `group_id`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `app_name`, `tenant_id`, `c_desc`, `c_use`, `effect`, `type`, `c_schema`) VALUES ('33', 'martin-biz-system-dev.yml', 'DEFAULT_GROUP', 'security:\r\n  oauth2:\r\n    client:\r\n      ignore-urls:\r\n        - /client/test\r\n        - /user/loadUserByUsername/*\r\n        - /**', 'f6205f62e9d692552c0a713a7cbd859c', '2019-11-06 17:39:10', '2019-11-07 14:45:52', NULL, '127.0.0.1', '', '', 'null', 'null', 'null', 'yaml', 'null');
INSERT INTO `nacos_config`.`config_info` (`id`, `data_id`, `group_id`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `app_name`, `tenant_id`, `c_desc`, `c_use`, `effect`, `type`, `c_schema`) VALUES ('34', 'martin-cloud-gateway-dev.yml', 'DEFAULT_GROUP', 'spring:\r\n  cloud:\r\n    gateway:\r\n      discovery:\r\n        locator:\r\n          enabled: true\r\n          lowerCaseServiceId: true\r\n      routes:\r\n        - id: martin-biz-auth\r\n          uri: lb://martin-biz-auth\r\n          predicates:\r\n            - Path=/auth/**\r\n          filters:\r\n            - StripPrefix=1\r\n        - id: martin-biz-resource\r\n          uri: lb://martin-biz-resource\r\n          predicates:\r\n            - Path=/resource/**\r\n          filters:\r\n            - StripPrefix=1\r\n        - id: martin-biz-sso\r\n          uri: lb://martin-biz-sso\r\n          predicates:\r\n            - Path=/sso/**\r\n          filters:\r\n            - StripPrefix=1\r\n        - id: martin-biz-swagger\r\n          uri: lb://martin-biz-swagger\r\n          predicates:\r\n            - Path=/swagger/**\r\n          filters:\r\n            - StripPrefix=1\r\n        - id: martin-biz-system\r\n          uri: lb://martin-biz-system\r\n          predicates:\r\n            - Path=/system/**\r\n          filters:\r\n            - StripPrefix=1', 'cfcef20ee3a2d9e31a9f2da01cd16d3e', '2019-11-06 17:39:10', '2019-11-07 14:49:20', NULL, '127.0.0.1', '', '', 'null', 'null', 'null', 'yaml', 'null');

/******************************************/
/*   数据库全名 = nacos_config   */
/*   表名称 = config_info_aggr   */
/******************************************/
CREATE TABLE `config_info_aggr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) NOT NULL COMMENT 'datum_id',
  `content` longtext NOT NULL COMMENT '内容',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) DEFAULT NULL,
  `tenant_id` varchar(128) DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfoaggr_datagrouptenantdatum` (`data_id`,`group_id`,`tenant_id`,`datum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='增加租户字段';


/******************************************/
/*   数据库全名 = nacos_config   */
/*   表名称 = config_info_beta   */
/******************************************/
CREATE TABLE `config_info_beta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) DEFAULT NULL COMMENT 'app_name',
  `content` longtext NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '修改时间',
  `src_user` text COMMENT 'source user',
  `src_ip` varchar(20) DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfobeta_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info_beta';

/******************************************/
/*   数据库全名 = nacos_config   */
/*   表名称 = config_info_tag   */
/******************************************/
CREATE TABLE `config_info_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) DEFAULT NULL COMMENT 'app_name',
  `content` longtext NOT NULL COMMENT 'content',
  `md5` varchar(32) DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '修改时间',
  `src_user` text COMMENT 'source user',
  `src_ip` varchar(20) DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfotag_datagrouptenanttag` (`data_id`,`group_id`,`tenant_id`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info_tag';

/******************************************/
/*   数据库全名 = nacos_config   */
/*   表名称 = config_tags_relation   */
/******************************************/
CREATE TABLE `config_tags_relation` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `tag_name` varchar(128) NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`),
  UNIQUE KEY `uk_configtagrelation_configidtag` (`id`,`tag_name`,`tag_type`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_tag_relation';

/******************************************/
/*   数据库全名 = nacos_config   */
/*   表名称 = group_capacity   */
/******************************************/
CREATE TABLE `group_capacity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
  `usage` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '使用量',
  `max_size` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='集群、各Group容量信息表';

/******************************************/
/*   数据库全名 = nacos_config   */
/*   表名称 = his_config_info   */
/******************************************/
CREATE TABLE `his_config_info` (
  `id` bigint(64) unsigned NOT NULL,
  `nid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) NOT NULL,
  `group_id` varchar(128) NOT NULL,
  `app_name` varchar(128) DEFAULT NULL COMMENT 'app_name',
  `content` longtext NOT NULL,
  `md5` varchar(32) DEFAULT NULL,
  `gmt_create` datetime NOT NULL DEFAULT '2010-05-05 00:00:00',
  `gmt_modified` datetime NOT NULL DEFAULT '2010-05-05 00:00:00',
  `src_user` text,
  `src_ip` varchar(20) DEFAULT NULL,
  `op_type` char(10) DEFAULT NULL,
  `tenant_id` varchar(128) DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`nid`),
  KEY `idx_gmt_create` (`gmt_create`),
  KEY `idx_gmt_modified` (`gmt_modified`),
  KEY `idx_did` (`data_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='多租户改造';


/******************************************/
/*   数据库全名 = nacos_config   */
/*   表名称 = tenant_capacity   */
/******************************************/
CREATE TABLE `tenant_capacity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
  `usage` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '使用量',
  `max_size` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数',
  `max_aggr_size` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='租户容量信息表';


CREATE TABLE `tenant_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) default '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) default '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint(20) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tenant_info_kptenantid` (`kp`,`tenant_id`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='tenant_info';

CREATE TABLE users (
	username varchar(50) NOT NULL PRIMARY KEY,
	password varchar(500) NOT NULL,
	enabled boolean NOT NULL
);

CREATE TABLE roles (
	username varchar(50) NOT NULL,
	role varchar(50) NOT NULL
);

INSERT INTO users (username, password, enabled) VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', TRUE);

INSERT INTO roles (username, role) VALUES ('nacos', 'ROLE_ADMIN');
