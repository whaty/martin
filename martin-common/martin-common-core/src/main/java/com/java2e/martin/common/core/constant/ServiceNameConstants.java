package com.java2e.martin.common.core.constant;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/3/1 11:21
 * @Describtion: 所有微服务服务名称，用于服务内部调用
 */
public final class ServiceNameConstants {
    private ServiceNameConstants() {
    }

    /**
     * 认证中心
     */
    public static final String MARTIN_BIZ_AUTH_SERVICE = "martin-biz-auth";

    /**
     * 示例资源中心
     */
    public static final String MARTIN_BIZ_RESOURCE_SERVICE = "martin-biz-resource";

    /**
     * 示例单点服务
     */
    public static final String MARTIN_BIZ_SSO_SERVICE = "martin-biz-sso";

}
