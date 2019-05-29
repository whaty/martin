package com.java2e.martin.common.core.exception;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/2/27 15:13
 * @Describtion: MartinException
 */
public class MartinException extends RuntimeException {
    private static final long serialVersionUID = 4913959406705554204L;

    public MartinException() {
        super();
    }

    public MartinException(String message) {
        super(message);
    }

    public MartinException(String message, Throwable cause) {
        super(message, cause);
    }

    public MartinException(Throwable cause) {
        super(cause);
    }

    protected MartinException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
