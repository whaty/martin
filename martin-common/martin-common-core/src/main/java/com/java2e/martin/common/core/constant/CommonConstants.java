package com.java2e.martin.common.core.constant;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/2/28 10:43
 * @Describtion: CommonConstants
 */
public final class CommonConstants {
    private CommonConstants() {
    }

    /**
     * header 中租户ID
     */
    public static final String TENANT_ID = "TENANT_ID";

    /**
     * 删除
     */
    public static final String STATUS_DEL = "1";

    /**
     * 正常
     */
    public static final String STATUS_NORMAL = "0";

    /**
     * 锁定
     */
    public static final String STATUS_LOCK = "1";

    /**
     * 菜单根节点标识
     */
    public static final Integer MENU_ROOT = 0;

    /**
     * 编码
     */
    public static final String UTF8 = "UTF-8";

    /**
     * 前端工程名
     */
    public static final String FRONT_END_PROJECT = "martin-ui";

    /**
     * 后端工程名
     */
    public static final String BACK_END_PROJECT = "martin";

    /**
     * 路由存放
     */
    public static final String ROUTE_KEY = "gateway_route_key";

    /**
     * spring boot admin 事件key
     */
    public static final String EVENT_KEY = "event_key";

    /**
     * 验证码前缀
     */
    public static final String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY_";

    /**
     * 成功标记
     */
    public static final Integer SUCCESS = 200;

    /**
     * 失败标记
     */
    public static final Integer FAIL = 500;

    /**
     * 默认存储bucket
     */
    public static final String BUCKET_NAME = "liangcan";

}
