package com.java2e.martin.common.core.exception;

import cn.hutool.core.util.StrUtil;
import com.java2e.martin.common.core.api.ApiErrorCode;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/3/1 10:56
 * @describtion 带有状态码的异常
 * @since 1.0
 */
public class StatefulException extends MartinException {
    private static final long serialVersionUID = 7378660735559113436L;
    private long status;

    public StatefulException() {
    }

    public StatefulException(String msg) {
        super(msg);
    }

    public StatefulException(String messageTemplate, Object... params) {
        super(StrUtil.format(messageTemplate, params));
    }

    public StatefulException(Throwable throwable) {
        super(throwable);
    }

    public StatefulException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public StatefulException(ApiErrorCode apiErrorCode) {
        new StatefulException(apiErrorCode.getCode(), apiErrorCode.getMsg());
    }

    public StatefulException(long status, String msg) {
        super(msg);
        this.status = status;
    }

    public StatefulException(long status, Throwable throwable) {
        super(throwable);
        this.status = status;
    }

    public StatefulException(long status, String msg, Throwable throwable) {
        super(msg, throwable);
        this.status = status;
    }

    public long getStatus() {
        return this.status;
    }
}
