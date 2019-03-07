package com.java2e.martin.common.core.exception;

/**
 * @author: liangcan
 * @version: 1.0
 * @date: 2019/2/27 15:13
 * @describtion: MartinException
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
