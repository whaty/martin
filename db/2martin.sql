/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : martin

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-10-09 11:43:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- TableJs structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
                                        `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                        `client_id` varchar(48) NOT NULL COMMENT '客户端唯一标识',
                                        `client_secret` varchar(256) NOT NULL COMMENT '客户端密码,必须要有前缀代表加密方式',
                                        `resource_ids` varchar(256) DEFAULT NULL COMMENT '客户端能访问的资源id集合,不能为空，用逗号分隔',
                                        `scope` varchar(256) NOT NULL COMMENT '围client的权限范围',
                                        `authorized_grant_types` varchar(256) DEFAULT NULL COMMENT '授权模式(可选值 授权码模式:authorization_code,密码模式:password,刷新token: refresh_token, 隐式模式: implicit: 客户端模式: client_credentials。支持多个用逗号分隔)',
                                        `web_server_redirect_uri` varchar(256) DEFAULT NULL COMMENT '客户端重定向uri',
                                        `authorities` varchar(256) DEFAULT NULL COMMENT '指定用户的权限范围，implicit和client_credentials需要',
                                        `access_token_validity` int(11) DEFAULT NULL COMMENT '设置access_token的有效时间(秒),默认(606012,12小时)',
                                        `refresh_token_validity` int(11) DEFAULT NULL COMMENT '设置refresh_token有效期(秒)，默认(606024*30, 30填)',
                                        `additional_information` varchar(4096) DEFAULT NULL COMMENT '额外的信息，值必须是json格式',
                                        `autoapprove` varchar(256) DEFAULT NULL COMMENT '默认false,适用于authorization_code模式,设置用户是否自动approval操作,设置true跳过用户确认授权操作页面，直接跳到redirect_uri',
                                        `creator` varchar(45) DEFAULT NULL COMMENT '创建人',
                                        `updater` varchar(45) DEFAULT NULL COMMENT '修改人',
                                        PRIMARY KEY (`id`),
                                        UNIQUE KEY `client_id_UNIQUE` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='oauth2客户端';

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('1', 'client1', '{bcrypt}$2a$10$gESiyFVZEXfaE9RWHoRhxOLxv7YKSg.n1bd0gWRqwZgGPcN2Rcn5i', null, 'select', 'client_credentials,refresh_token', null, null, null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('2', 'client2', '{bcrypt}$2a$10$gESiyFVZEXfaE9RWHoRhxOLxv7YKSg.n1bd0gWRqwZgGPcN2Rcn5i', null, 'select', 'password,refresh_token', null, null, null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('3', 'client3', '{bcrypt}$2a$10$gESiyFVZEXfaE9RWHoRhxOLxv7YKSg.n1bd0gWRqwZgGPcN2Rcn5i', null, 'select', 'authorization_code,refresh_token', 'http://127.0.0.1:9402/login,http://127.0.0.1:9403/login', null, null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('4', 'client4', '{bcrypt}$2a$10$gESiyFVZEXfaE9RWHoRhxOLxv7YKSg.n1bd0gWRqwZgGPcN2Rcn5i', null, 'select', 'implicit', null, null, null, null, null, null, null, null);

-- ----------------------------
-- TableJs structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
                            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
                            `sort` int(11) DEFAULT NULL COMMENT '排序',
                            `parent_id` int(11) DEFAULT NULL,
                            `tenant_id` int(11) DEFAULT NULL COMMENT '所属租户',
                            `del_flag` char(1) DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
                            `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            `creator` varchar(45) DEFAULT NULL COMMENT '创建人',
                            `updater` varchar(45) DEFAULT NULL COMMENT '修改人',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统部门';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', 'liangcan', null, null, null, '0', '2019-08-27 10:38:59', null, null, null);
INSERT INTO `sys_dept` VALUES ('2', 'liangcan', null, null, null, '0', '2019-08-27 10:39:54', null, null, null);

-- ----------------------------
-- TableJs structure for sys_dept_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_role`;
CREATE TABLE `sys_dept_role` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                 `dept_id` int(11) NOT NULL COMMENT '部门id',
                                 `role_id` int(11) NOT NULL COMMENT '角色id',
                                 `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                 `creator` varchar(45) DEFAULT NULL COMMENT '创建人',
                                 `updater` varchar(45) DEFAULT NULL COMMENT '修改人',
                                 PRIMARY KEY (`id`),
                                 KEY `fk_sys_dept_has_sys_role_sys_role1_idx` (`role_id`),
                                 KEY `fk_sys_dept_has_sys_role_sys_dept1_idx` (`dept_id`),
                                 CONSTRAINT `fk_sys_dept_has_sys_role_sys_dept1` FOREIGN KEY (`dept_id`) REFERENCES `sys_dept` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                                 CONSTRAINT `fk_sys_dept_has_sys_role_sys_role1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统部门角色关系';

-- ----------------------------
-- Records of sys_dept_role
-- ----------------------------

-- ----------------------------
-- TableJs structure for sys_dept_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_user`;
CREATE TABLE `sys_dept_user` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                 `user_id` int(11) NOT NULL COMMENT '用户id',
                                 `dept_id` int(11) NOT NULL COMMENT '部门id',
                                 `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                 `creator` varchar(45) DEFAULT NULL COMMENT '创建人',
                                 `updater` varchar(45) DEFAULT NULL COMMENT '修改人',
                                 PRIMARY KEY (`id`),
                                 KEY `fk_sys_user_has_sys_dept_sys_dept1_idx` (`dept_id`),
                                 KEY `fk_sys_user_has_sys_dept_sys_user1_idx` (`user_id`),
                                 CONSTRAINT `fk_sys_user_has_sys_dept_sys_dept1` FOREIGN KEY (`dept_id`) REFERENCES `sys_dept` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                                 CONSTRAINT `fk_sys_user_has_sys_dept_sys_user1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户部门关系';

-- ----------------------------
-- Records of sys_dept_user
-- ----------------------------

-- ----------------------------
-- TableJs structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
                            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                            `value` varchar(100) NOT NULL COMMENT '数据值',
                            `label` varchar(100) NOT NULL COMMENT '标签名',
                            `type` varchar(100) NOT NULL COMMENT '类型',
                            `description` varchar(100) NOT NULL COMMENT '描述',
                            `sort` int(10) NOT NULL COMMENT '排序（升序）',
                            `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
                            `tenant_id` int(11) NOT NULL DEFAULT '0' COMMENT '所属租户',
                            `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
                            `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                            `creator` varchar(45) DEFAULT NULL COMMENT '创建人',
                            `updater` varchar(45) DEFAULT NULL COMMENT '修改人',
                            PRIMARY KEY (`id`) USING BTREE,
                            KEY `sys_dict_value` (`value`) USING BTREE,
                            KEY `sys_dict_label` (`label`) USING BTREE,
                            KEY `sys_dict_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统字典';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', '1', '1', 'flag_resource_status', '菜单', '1', null, '0', '0', '2019-09-12 16:39:25', '2019-09-12 16:39:25', null, null);
INSERT INTO `sys_dict` VALUES ('2', '2', '2', 'flag_resource_status', '操作', '2', null, '0', '0', '2019-09-12 16:39:51', '2019-09-12 16:39:51', null, null);
INSERT INTO `sys_dict` VALUES ('3', '3', '3', 'flag_resource_status', '文件', '3', null, '0', '0', '2019-09-12 16:40:38', '2019-09-12 16:40:38', null, null);
INSERT INTO `sys_dict` VALUES ('4', '4', '4', 'flag_resource_status', '页面元素', '4', null, '0', '0', '2019-09-12 16:40:59', '2019-09-12 16:40:59', null, null);

-- ----------------------------
-- TableJs structure for sys_element
-- ----------------------------
DROP TABLE IF EXISTS `sys_element`;
CREATE TABLE `sys_element` (
                               `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                               `name` varchar(32) NOT NULL COMMENT '页面元素名称',
                               `authority` varchar(32) NOT NULL COMMENT '权限编码，以element_开头',
                               `url` varchar(250) DEFAULT NULL COMMENT '页面元素路径',
                               `sort` int(11) DEFAULT '1' COMMENT '排序值',
                               `tenant_id` int(11) NOT NULL DEFAULT '0' COMMENT '所属租户',
                               `del_flag` char(1) DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
                               `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                               `creator` varchar(45) DEFAULT NULL COMMENT '创建人',
                               `updater` varchar(45) DEFAULT NULL COMMENT '修改人',
                               PRIMARY KEY (`id`) USING BTREE,
                               UNIQUE KEY `code_UNIQUE` (`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统页面元素';

-- ----------------------------
-- Records of sys_element
-- ----------------------------

-- ----------------------------
-- TableJs structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
                            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `name` varchar(32) NOT NULL COMMENT '文件名称',
                            `authority` varchar(32) NOT NULL COMMENT '权限编码，以file_开通',
                            `url` varchar(250) DEFAULT NULL COMMENT '文件路径',
                            `sort` int(11) DEFAULT '1' COMMENT '排序值',
                            `tenant_id` int(11) NOT NULL DEFAULT '0' COMMENT '所属租户',
                            `del_flag` char(1) DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
                            `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            `creator` varchar(45) DEFAULT NULL COMMENT '创建人',
                            `updater` varchar(45) DEFAULT NULL COMMENT '修改人',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统操作';

-- ----------------------------
-- Records of sys_file
-- ----------------------------

-- ----------------------------
-- TableJs structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
                           `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
                           `type` char(1) DEFAULT '1' COMMENT '日志类型',
                           `title` varchar(255) DEFAULT '' COMMENT '日志标题',
                           `service_id` varchar(32) DEFAULT NULL COMMENT '服务ID',
                           `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
                           `remote_addr` varchar(255) DEFAULT NULL COMMENT '操作IP地址',
                           `user_agent` varchar(1000) DEFAULT NULL COMMENT '用户代理',
                           `request_uri` varchar(255) DEFAULT NULL COMMENT '请求URI',
                           `method` varchar(10) DEFAULT NULL COMMENT '操作方式',
                           `params` text COMMENT '操作提交的数据',
                           `time` mediumtext COMMENT '执行时间',
                           `exception` text COMMENT '异常信息',
                           `tenant_id` int(11) DEFAULT '0' COMMENT '所属租户',
                           `del_flag` char(1) DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
                           `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                           `creator` varchar(45) DEFAULT NULL COMMENT '创建人',
                           `updater` varchar(45) DEFAULT NULL COMMENT '修改人',
                           PRIMARY KEY (`id`) USING BTREE,
                           KEY `sys_log_create_by` (`create_by`) USING BTREE,
                           KEY `sys_log_request_uri` (`request_uri`) USING BTREE,
                           KEY `sys_log_type` (`type`) USING BTREE,
                           KEY `sys_log_create_date` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- TableJs structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
                            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `name` varchar(32) NOT NULL COMMENT '菜单名称',
                            `authority` varchar(32) NOT NULL COMMENT '权限编码，以menu_开头',
                            `path` varchar(128) DEFAULT NULL COMMENT '前端URL',
                            `parent_id` int(11) DEFAULT NULL COMMENT '父菜单ID',
                            `icon` varchar(32) DEFAULT NULL COMMENT '图标',
                            `locale` varchar(45) DEFAULT NULL,
                            `component` varchar(64) DEFAULT NULL COMMENT '前端组件',
                            `sort` int(11) DEFAULT '1' COMMENT '排序值',
                            `tenant_id` int(11) NOT NULL DEFAULT '0' COMMENT '所属租户',
                            `del_flag` char(1) DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
                            `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            `creator` varchar(45) DEFAULT NULL COMMENT '创建人',
                            `updater` varchar(45) DEFAULT NULL COMMENT '修改人',
                            PRIMARY KEY (`id`) USING BTREE,
                            UNIQUE KEY `code_UNIQUE` (`authority`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统菜单';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '用户登录', 'user-login', '/user/login', '2', null, null, './User/Login', '1', '0', '1', '2019-09-27 10:59:31', null, null, null);
INSERT INTO `sys_menu` VALUES ('2', '用户', 'user', '/user', '0', null, null, null, '1', '0', '1', '2019-09-20 11:22:06', null, null, null);
INSERT INTO `sys_menu` VALUES ('3', '注册', 'user-register', '/user/register', '2', null, null, null, '3', '0', '1', '2019-09-20 11:55:44', null, null, null);
INSERT INTO `sys_menu` VALUES ('4', '注册结果', 'user-register-result', '/user/register-result', '2', null, null, null, '4', '0', '1', '2019-09-20 15:04:54', null, null, null);
INSERT INTO `sys_menu` VALUES ('5', '分析页', 'dashboard-analysis', '/dashboard/analysis', '6', null, null, './Dashboard/Analysis', '1', '0', '1', '2019-09-20 15:06:43', null, null, null);
INSERT INTO `sys_menu` VALUES ('6', 'dashboard', 'dashboard', '/dashboard', '0', 'dashboard', null, null, '1', '0', '1', '2019-09-23 10:23:21', null, null, null);
INSERT INTO `sys_menu` VALUES ('8', '监控页', 'dashboard-monitor', '/dashboard/monitor', '6', null, null, null, '1', '0', '1', '2019-09-23 10:25:09', null, null, null);
INSERT INTO `sys_menu` VALUES ('9', '工作台', 'dashboard-workplace', '/dashboard/workplace', '6', null, null, './Dashboard/Workplace', '1', '0', '1', '2019-09-23 10:27:17', null, null, null);
INSERT INTO `sys_menu` VALUES ('10', '表单页', 'form', '/form', '0', 'form', null, null, '1', '0', '1', '2019-09-23 10:28:47', null, null, null);
INSERT INTO `sys_menu` VALUES ('11', '基础表单', 'form-basic-form', '/form/basic-form', '10', null, null, './Forms/BasicForm', '1', '0', '1', '2019-09-23 10:29:36', null, null, null);
INSERT INTO `sys_menu` VALUES ('12', '分步表单', 'form-step-form', '/form/step-form', '10', null, null, './Forms/StepForm', '1', '0', '1', '2019-09-23 10:31:14', null, null, null);
INSERT INTO `sys_menu` VALUES ('13', '高级表单', 'form-advanced-form', '/form/advanced-form', '10', null, null, './Forms/AdvancedForm', '1', '0', '1', '2019-09-23 10:32:07', null, null, null);
INSERT INTO `sys_menu` VALUES ('14', '列表页', 'list', '/list', '0', 'table', null, null, '1', '0', '1', '2019-09-23 10:32:56', null, null, null);
INSERT INTO `sys_menu` VALUES ('15', '查询列表', 'list-table-list', '/list/table-list', '14', null, null, './List/TableList', '1', '0', '1', '2019-09-23 10:33:49', null, null, null);
INSERT INTO `sys_menu` VALUES ('16', '标准列表', 'list-basic-list', '/list/basic-list', '14', null, null, './List/BasicList', '1', '0', '1', '2019-09-23 10:34:31', null, null, null);
INSERT INTO `sys_menu` VALUES ('17', '卡片列表', 'list-card-list', '/list/card-list', '14', null, null, './List/CardList', '1', '0', '1', '2019-09-23 10:35:06', null, null, null);
INSERT INTO `sys_menu` VALUES ('18', '搜索列表', 'list-search', '/list/search', '14', null, null, './List/List', '1', '0', '1', '2019-09-23 10:36:17', null, null, null);
INSERT INTO `sys_menu` VALUES ('19', '搜索列表(文章)', 'list-search-articles', '/list/search/articles', '18', null, null, './List/Articles', '1', '0', '1', '2019-09-23 10:38:07', null, null, null);
INSERT INTO `sys_menu` VALUES ('20', '搜索列表(项目)', 'list-search-projects', '/list/search/projects', '18', null, null, './List/Projects', '1', '0', '1', '2019-09-23 10:40:19', null, null, null);
INSERT INTO `sys_menu` VALUES ('21', '搜索列表(应用)', 'list-search-applications', '/list/search/applications', '18', null, null, './List/Applications', '1', '0', '1', '2019-09-23 10:41:56', null, null, null);
INSERT INTO `sys_menu` VALUES ('22', '详情页', 'profile', '/profile', '0', 'profile', null, null, '1', '0', '1', '2019-09-23 10:43:28', null, null, null);
INSERT INTO `sys_menu` VALUES ('23', '基础详情页', 'profile-basic', '/profile/basic', '22', null, null, './Profile/BasicProfile', '1', '0', '1', '2019-09-23 10:44:41', null, null, null);
INSERT INTO `sys_menu` VALUES ('24', '高级详情页', 'profile-advanced', '/profile/advanced', '22', null, null, './Profile/AdvancedProfile', '1', '0', '1', '2019-09-23 10:45:26', null, null, null);
INSERT INTO `sys_menu` VALUES ('25', '结果页', 'result', '/result', '0', 'check-circle-o', null, null, '1', '0', '0', '2019-09-23 10:47:49', null, null, null);
INSERT INTO `sys_menu` VALUES ('26', '成功页', 'result-success', '/result/success', '25', null, null, './Result/Success', '1', '0', '0', '2019-09-23 10:49:13', null, null, null);
INSERT INTO `sys_menu` VALUES ('27', '失败页', 'result-fail', '/result/fail', '25', null, null, './Result/Error', '1', '0', '0', '2019-09-23 10:49:57', null, null, null);
INSERT INTO `sys_menu` VALUES ('28', '异常页', 'exception', '/exception', '0', 'warning', null, null, '1', '0', '0', '2019-09-23 10:51:01', null, null, null);
INSERT INTO `sys_menu` VALUES ('29', '403', 'exception-403', '/exception/403', '28', null, null, './Exception/403', '1', '0', '0', '2019-09-23 10:51:39', null, null, null);
INSERT INTO `sys_menu` VALUES ('30', '404', 'exception-404', '/exception/404', '28', null, null, './Exception/404', '1', '0', '0', '2019-09-23 10:52:00', null, null, null);
INSERT INTO `sys_menu` VALUES ('31', '500', 'exception-500', '/exception/500', '28', null, null, './Exception/500', '1', '0', '0', '2019-09-23 10:52:23', null, null, null);
INSERT INTO `sys_menu` VALUES ('32', '个人页', 'account', '/account', '0', 'user', null, null, '1', '0', '0', '2019-09-23 10:54:28', null, null, null);
INSERT INTO `sys_menu` VALUES ('33', '个人中心', 'account-center', '/account/center', '32', null, null, './Account/Center/Center', '1', '0', '0', '2019-09-23 10:55:30', null, null, null);
INSERT INTO `sys_menu` VALUES ('34', '个人中心(文章)', 'accout-center-article', '/account/center/articles', '33', null, null, './Account/Center/Articles', '1', '0', '0', '2019-09-23 10:57:18', null, null, null);
INSERT INTO `sys_menu` VALUES ('35', '个人中心(应用)', 'account-center-applications', '/account/center/applications', '33', null, null, './Account/Center/Applications', '1', '0', '0', '2019-09-23 10:58:43', null, null, null);
INSERT INTO `sys_menu` VALUES ('36', '个人中心(项目)', 'account-center-projects', '/account/center/projects', '33', null, null, './Account/Center/Projects', '1', '0', '0', '2019-09-23 10:59:36', null, null, null);
INSERT INTO `sys_menu` VALUES ('37', '个人设置', 'account-settings', '/account/settings', '32', null, null, './Account/Settings/Info', '1', '0', '0', '2019-09-23 11:01:11', null, null, null);
INSERT INTO `sys_menu` VALUES ('38', '个人设置(基本)', 'account-settings-base', '/account/settings/base', '37', null, null, './Account/Settings/BaseView', '1', '0', '0', '2019-09-23 11:02:27', null, null, null);
INSERT INTO `sys_menu` VALUES ('39', '个人设置(安全)', 'account-settings-security', '/account/settings/security', '37', null, null, './Account/Settings/SecurityView', '1', '0', '0', '2019-09-23 11:03:24', null, null, null);
INSERT INTO `sys_menu` VALUES ('40', '个人设置(绑定)', 'account-settings-binding', '/account/settings/binding', '37', null, null, './Account/Settings/BindingView', '1', '0', '0', '2019-09-23 11:03:59', null, null, null);
INSERT INTO `sys_menu` VALUES ('41', '个人设置(提示)', 'account-settings-notification', '/account/settings/notification', '37', null, null, './Account/Settings/NotificationView', '1', '0', '1', '2019-09-23 11:04:47', null, null, null);
INSERT INTO `sys_menu` VALUES ('42', '图形编辑器', 'editor', '/editor', '0', 'highlight', null, null, '1', '0', '1', '2019-09-23 11:05:51', null, null, null);
INSERT INTO `sys_menu` VALUES ('43', '流程编辑器', 'editorflow', '/editor/flow', '42', null, null, './Editor/GGEditor/Flow', '1', '0', '0', '2019-09-23 11:06:35', null, null, null);
INSERT INTO `sys_menu` VALUES ('44', '脑图编辑器', 'editor-mind', '/editor/mind', '42', null, null, './Editor/GGEditor/Mind', '1', '0', '0', '2019-09-23 11:07:29', null, null, null);
INSERT INTO `sys_menu` VALUES ('45', '拓扑编辑器', 'editor-koni', '/editor/koni', '42', null, null, './Editor/GGEditor/Koni', '1', '0', '0', '2019-09-23 11:08:19', null, null, null);
INSERT INTO `sys_menu` VALUES ('46', '列表页面', 'table-table', '/table/table', '0', null, null, './TableJs/TableJs', '1', '0', '0', '2019-09-24 10:13:33', null, null, null);
INSERT INTO `sys_menu` VALUES ('47', '100', '12321', '100', '100', '100', '100', '312321', '100', '0', '0', '2019-09-29 11:21:34', null, null, null);
INSERT INTO `sys_menu` VALUES ('49', '19', '恶趣味', '19', '19', '18', '18', '打', '19', '0', '0', '2019-09-29 11:25:36', null, null, null);
INSERT INTO `sys_menu` VALUES ('50', '20', 'eqeq', '20', '20', '18', '20', 'eqwe', '20', '0', '0', '2019-09-29 11:31:49', null, null, null);
INSERT INTO `sys_menu` VALUES ('51', '23', '绕弯儿', '20', '21', '22', '22', '4324', '18', '0', '0', '2019-09-29 15:46:35', null, null, null);

-- ----------------------------
-- TableJs structure for sys_operation
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation`;
CREATE TABLE `sys_operation` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                 `name` varchar(32) NOT NULL COMMENT '操作名称',
                                 `authority` varchar(64) DEFAULT NULL COMMENT '权限编码，以operation_开头',
                                 `parent_id` int(11) DEFAULT NULL COMMENT '父操作id',
                                 `icon` varchar(32) DEFAULT NULL COMMENT '图标',
                                 `component` varchar(64) DEFAULT NULL COMMENT '前端组件',
                                 `sort` int(11) DEFAULT '1' COMMENT '排序值',
                                 `tenant_id` int(11) NOT NULL DEFAULT '0' COMMENT '所属租户',
                                 `del_flag` char(1) DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
                                 `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                 `creator` varchar(45) DEFAULT NULL COMMENT '创建人',
                                 `updater` varchar(45) DEFAULT NULL COMMENT '修改人',
                                 PRIMARY KEY (`id`) USING BTREE,
                                 UNIQUE KEY `code_UNIQUE` (`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统操作';

-- ----------------------------
-- Records of sys_operation
-- ----------------------------

-- ----------------------------
-- TableJs structure for sys_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                 `type` varchar(50) NOT NULL COMMENT '权限类型',
                                 `resource_id` int(11) NOT NULL COMMENT '资源id',
                                 `dict_id` int(11) NOT NULL COMMENT '权限类型',
                                 `tenant_id` int(11) NOT NULL DEFAULT '0' COMMENT '所属租户',
                                 `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
                                 `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                 `creator` varchar(45) DEFAULT NULL COMMENT '创建人',
                                 `updater` varchar(45) DEFAULT NULL COMMENT '修改人',
                                 PRIMARY KEY (`id`) USING BTREE,
                                 KEY `sys_dict_del_flag` (`del_flag`) USING BTREE,
                                 KEY `fk_sys_privilege_sys_dict1_idx` (`dict_id`),
                                 CONSTRAINT `fk_sys_privilege_sys_dict1` FOREIGN KEY (`dict_id`) REFERENCES `sys_dict` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统权限';

-- ----------------------------
-- Records of sys_privilege
-- ----------------------------
INSERT INTO `sys_privilege` VALUES ('1', '1', '1', '1', '0', '0', '2019-09-12 16:29:22', '2019-09-12 16:29:22', null, null);

-- ----------------------------
-- TableJs structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
                            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `role_name` varchar(64) NOT NULL COMMENT '角色名称',
                            `role_code` varchar(64) NOT NULL COMMENT '角色编码',
                            `role_desc` varchar(255) DEFAULT NULL COMMENT '角色描述',
                            `ds_type` char(1) NOT NULL DEFAULT '2' COMMENT '数据权限类型',
                            `ds_scope` varchar(255) DEFAULT NULL COMMENT '数据权限范围',
                            `tenant_id` int(11) DEFAULT NULL COMMENT '所属租户',
                            `del_flag` char(1) DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
                            `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            `creator` varchar(45) DEFAULT NULL COMMENT '创建人',
                            `updater` varchar(45) DEFAULT NULL COMMENT '修改人',
                            PRIMARY KEY (`id`) USING BTREE,
                            UNIQUE KEY `role_idx1_role_code` (`role_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', 'admin', '1', '2', '1', '1', '0', '2019-09-12 16:22:22', null, null, null);

-- ----------------------------
-- TableJs structure for sys_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_privilege`;
CREATE TABLE `sys_role_privilege` (
                                      `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                      `role_id` int(11) NOT NULL COMMENT '角色id',
                                      `privilege_id` int(11) NOT NULL COMMENT '权限id',
                                      `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                      `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                      `creator` varchar(45) DEFAULT NULL COMMENT '创建人',
                                      `updater` varchar(45) DEFAULT NULL COMMENT '修改人',
                                      PRIMARY KEY (`id`),
                                      KEY `fk_sys_role_has_sys_privilege_sys_privilege1_idx` (`privilege_id`),
                                      KEY `fk_sys_role_has_sys_privilege_sys_role1_idx` (`role_id`),
                                      CONSTRAINT `fk_sys_role_has_sys_privilege_sys_privilege1` FOREIGN KEY (`privilege_id`) REFERENCES `sys_privilege` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                                      CONSTRAINT `fk_sys_role_has_sys_privilege_sys_role1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统角色权限关系';

-- ----------------------------
-- Records of sys_role_privilege
-- ----------------------------
INSERT INTO `sys_role_privilege` VALUES ('1', '1', '1', '2019-09-12 16:30:17', null, null, null);

-- ----------------------------
-- TableJs structure for sys_social_details
-- ----------------------------
DROP TABLE IF EXISTS `sys_social_details`;
CREATE TABLE `sys_social_details` (
                                      `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主鍵',
                                      `type` varchar(16) NOT NULL COMMENT '类型',
                                      `remark` varchar(64) DEFAULT NULL COMMENT '描述',
                                      `app_id` varchar(64) NOT NULL COMMENT 'appid',
                                      `app_secret` varchar(64) NOT NULL COMMENT 'app_secret',
                                      `redirect_url` varchar(128) DEFAULT NULL COMMENT '回调地址',
                                      `tenant_id` int(11) NOT NULL DEFAULT '0' COMMENT '所属租户',
                                      `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
                                      `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                      `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                      `creator` varchar(45) DEFAULT NULL COMMENT '创建人',
                                      `updater` varchar(45) DEFAULT NULL COMMENT '修改人',
                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统社交账号';

-- ----------------------------
-- Records of sys_social_details
-- ----------------------------

-- ----------------------------
-- TableJs structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
                            `id` int(11) NOT NULL COMMENT '主键',
                            `username` varchar(64) NOT NULL COMMENT '用户名',
                            `pwd` varchar(255) NOT NULL COMMENT '密码',
                            `salt` varchar(255) DEFAULT NULL COMMENT '随机盐',
                            `age` int(3) DEFAULT NULL COMMENT '年纪',
                            `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
                            `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
                            `signature` varchar(100) DEFAULT NULL COMMENT '签名',
                            `title` varchar(45) DEFAULT NULL COMMENT '头衔',
                            `classification` varchar(100) DEFAULT NULL COMMENT '分类',
                            `address` varchar(150) DEFAULT NULL COMMENT '地址',
                            `phone` varchar(20) DEFAULT NULL COMMENT '电话',
                            `dept_id` int(11) DEFAULT NULL COMMENT '部门ID',
                            `wx_openid` varchar(32) DEFAULT NULL COMMENT '微信openid',
                            `qq_openid` varchar(32) DEFAULT NULL COMMENT 'QQ openid',
                            `tenant_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '所属租户',
                            `lock_flag` char(1) DEFAULT '0' COMMENT '0-正常，9-锁定',
                            `del_flag` char(1) DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
                            `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                            `creator` varchar(45) DEFAULT NULL COMMENT '创建人',
                            `updater` varchar(45) DEFAULT NULL COMMENT '修改人',
                            PRIMARY KEY (`id`) USING BTREE,
                            UNIQUE KEY `username_UNIQUE` (`username`),
                            KEY `user_wx_openid` (`wx_openid`) USING BTREE,
                            KEY `user_qq_openid` (`qq_openid`) USING BTREE,
                            KEY `user_idx1_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '0', '2019-09-12 14:20:21', null, null, null);
INSERT INTO `sys_user` VALUES ('2', 'user1', '{bcrypt}$2a$10$vAxxCnKsa0MLdCLoP9A2UOsBMdsVLOaodDIezhtyFhkLdLilo6Mce', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '0', '2019-09-18 15:01:37', null, null, null);

-- ----------------------------
-- TableJs structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                 `user_id` int(11) NOT NULL COMMENT '用户id',
                                 `role_id` int(11) NOT NULL COMMENT '角色id',
                                 `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
                                 `creator` varchar(45) DEFAULT NULL COMMENT '创建人',
                                 `updater` varchar(45) DEFAULT NULL COMMENT '修改人',
                                 PRIMARY KEY (`id`),
                                 KEY `fk_sys_user_has_sys_role_sys_role1_idx` (`role_id`),
                                 KEY `fk_sys_user_has_sys_role_sys_user_idx` (`user_id`),
                                 CONSTRAINT `fk_sys_user_has_sys_role_sys_role1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                                 CONSTRAINT `fk_sys_user_has_sys_role_sys_user` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户角色关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', '2019-09-12 16:22:32', null, null, null);
INSERT INTO `sys_user_role` VALUES ('2', '2', '1', '2019-09-18 15:05:32', null, null, null);
