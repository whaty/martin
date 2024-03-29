package com.java2e.martin.common.core.api;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/8/22
 * @describtion ApiErrorCode
 * @since 1.0
 */
public enum ApiErrorCode implements IErrorCode {
    FAILED(500, "操作发生错误，请联系管理员"),

    SUCCESS(200, "操作成功"),

    UNAUTHORIZED(401, "未经授权的操作"),

    FORBIDDEN(403, "禁止操作"),

    PAGE_LIMIT_ERROR(1000001, "分页参数过大"),

    USER_NOT_FOUND(9404001, "查无此用户"),

    ROLE_NOT_FOUND(9404002, "用户未分配角色"),

    PRIVILEGE_NOT_FOUND(9404003, "用户未授权");


    private final long code;
    private final String msg;

    /**
     * 初始化
     *
     * @param code 错误码
     * @param msg  错误信息
     */
    ApiErrorCode(final long code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ApiErrorCode fromCode(int code) {
        ApiErrorCode[] ecs = values();
        ApiErrorCode[] var3 = ecs;
        int var4 = ecs.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            ApiErrorCode ec = var3[var5];
            if (ec.getCode() == code) {
                return ec;
            }
        }

        return SUCCESS;
    }

    @Override
    public long getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    @Override
    public String toString() {
        return String.format(" ErrorCode:{code=%s, msg=%s} ", this.code, this.msg);
    }
}
