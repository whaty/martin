package com.java2e.martin.common.core.exception;

import com.java2e.martin.common.core.api.ApiErrorCode;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/9/4
 * @Describtion: SecurityException，带状态码的安全异常
 */
public class SecurityException extends StatefulException {
    public SecurityException() {
        super();
    }

    public SecurityException(String msg) {
        super(msg);
    }

    public SecurityException(String messageTemplate, Object... params) {
        super(messageTemplate, params);
    }

    public SecurityException(Throwable throwable) {
        super(throwable);
    }

    public SecurityException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public SecurityException(ApiErrorCode apiErrorCode) {
        super(apiErrorCode);
    }

    public SecurityException(int status, String msg) {
        super(status, msg);
    }

    public SecurityException(int status, Throwable throwable) {
        super(status, throwable);
    }

    public SecurityException(int status, String msg, Throwable throwable) {
        super(status, msg, throwable);
    }

}
