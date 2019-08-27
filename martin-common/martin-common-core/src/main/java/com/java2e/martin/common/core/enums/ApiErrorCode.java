package com.java2e.martin.common.core.enums;

import com.java2e.martin.common.core.api.IErrorCode;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/8/22
 * @Describtion: ApiErrorCode
 */
public enum ApiErrorCode implements IErrorCode {
    FAILED(500L, "操作失败"),

    SUCCESS(200L, "操作成功");

    private final long code;
    private final String msg;

    /**
     * 初始化
     *
     * @param code 错误码
     * @param msg  错误信息
     */
    private ApiErrorCode(final long code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ApiErrorCode fromCode(long code) {
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
