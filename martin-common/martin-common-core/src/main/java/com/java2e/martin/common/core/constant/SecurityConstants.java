package com.java2e.martin.common.core.constant;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/3/1 11:17
 * @describtion SecurityConstants
 * @since 1.0
 */
public final class SecurityConstants {
    private SecurityConstants() {
    }

    public static final String MARTIN_ROUTES = "routes";
    public static final String AUTHORITIES = "authorities";

    /**
     * 刷新
     */
    public static final String REFRESH_TOKEN = "refresh_token";
    /**
     * 验证码有效期
     */
    public static final int CODE_TIME = 60;
    /**
     * 验证码长度
     */
    public static final String CODE_SIZE = "4";
    /**
     * 角色前缀
     */
    public static final String ROLE = "ROLE_";
    /**
     * 前缀
     */
    public static final String MARTIN_PREFIX = "martin_";

    /**
     * oauth 相关前缀
     */
    public static final String OAUTH_PREFIX = "oauth:";
    /**
     * 项目的license
     */
    public static final String MARTIN_LICENSE = "made by martin";


    /**
     * 标志
     */
    public static final String MARTIN_INNER = "martin-inner";

    /**
     * OAUTH URL
     */
    public static final String OAUTH_TOKEN_URL = "/oauth/token";

    /**
     * 手机号登录URL
     */
    public static final String SMS_TOKEN_URL = "/mobile/token/sms";

    /**
     * 社交登录URL
     */
    public static final String SOCIAL_TOKEN_URL = "/mobile/token/social";
    /**
     * 自定义登录URL
     */
    public static final String MOBILE_TOKEN_URL = "/mobile/token/*";
    /**
     * oauth 客户端信息
     */
    public static final String CLIENT_DETAILS_KEY = "martin_oauth:client:details";

    /**
     * 微信获取OPENID
     */
    public static final String WX_AUTHORIZATION_CODE_URL = "https://api.weixin.qq.com/sns/oauth2/access_token" +
            "?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    /**
     * {bcrypt} 加密的特征码
     */
    public static final String BCRYPT = "{bcrypt}";
    /**
     * sys_oauth_client_details 表的字段，不包括client_id、client_secret
     */
    public static final String CLIENT_FIELDS = "client_id, CONCAT('{noop}',client_secret) as client_secret, resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";

    /**
     * JdbcClientDetailsService 查询语句
     */
    public static final String BASE_FIND_STATEMENT = "select " + CLIENT_FIELDS
            + " from sys_oauth_client_details";

    /**
     * 默认的查询语句
     */
    public static final String DEFAULT_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by client_id";

    /**
     * 按条件client_id 查询
     */
    public static final String DEFAULT_SELECT_STATEMENT = BASE_FIND_STATEMENT + " where client_id = ?";

    /**
     * 资源服务器默认bean名称
     */
    public static final String RESOURCE_SERVER_CONFIGURER = "resourceServerConfigurerAdapter";

    /**
     * 客户端模式
     */
    public static final String CLIENT_CREDENTIALS = "client_credentials";

    /**
     * 用户ID字段
     */
    public static final String TOKEN_USER_ID = "user_id";

    /**
     * 用户名字段
     */
    public static final String TOKEN_USERNAME = "username";

    /**
     * 用户部门字段
     */
    public static final String TOKEN_DEPT_ID = "dept_id";

    /**
     * 用户角色字段
     */
    public static final String TOKEN_ROLE_IDS = "role_ids";

    /**
     * 租户ID 字段
     */
    public static final String TOKEN_TENANT_ID = "tenant_id";

    /**
     * 协议字段
     */
    public static final String TOKEN_LICENSE = "license";
}
