package com.java2e.martin.common.core.exception;

import com.java2e.martin.common.core.api.ApiErrorCode;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/9/4
 * @describtion SecurityException，带状态码的安全异常
 * @since 1.0
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

    public SecurityException(long status, String msg) {
        super(status, msg);
    }

    public SecurityException(long status, Throwable throwable) {
        super(status, throwable);
    }

    public SecurityException(long status, String msg, Throwable throwable) {
        super(status, msg, throwable);
    }

}
