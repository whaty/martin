package com.java2e.martin.common.core.constant;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/8/27
 * @describtion CacheConstants，所有缓存都放到martin这个顶级标签下，和其他缓存做区分
 * @since 1.0
 */
public class CacheConstants {
    /**
     * 菜单信息缓存
     */
    public static final String MENU_DETAILS = "martin:menu_details";

    /**
     * 用户信息缓存
     */
    public static final String USER_DETAILS = "martin:user_details";

    /**
     * 字典信息缓存
     */
    public static final String DICT_DETAILS = "martin:dict_details";


    /**
     * oauth 客户端信息
     */
    public static final String CLIENT_DETAILS_KEY = "martin:oauth2:client_details";


    /**
     * spring boot admin 事件key
     */
    public static final String EVENT_KEY = "martin:event_key";

    /**
     * 路由存放
     */
    public static final String ROUTE_KEY = "martin:gateway_route_key";

    /**
     * 参数缓存
     */
    public static final String PARAMS_DETAILS = "martin:params_details";

    /**
     * 租户缓存
     */
    public static final String TENANT_DETAILS = "martin:tenant_details";
}
