package com.java2e.martin.common.core.exception;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/3/1 10:57
 * @Describtion: 工具类异常
 */
public class UtilException extends MartinException {

    private static final long serialVersionUID = -740305562410697961L;

    public UtilException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(String messageTemplate, Object... params) {
        super(StrUtil.format(messageTemplate, params));
    }

    public UtilException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public UtilException(Throwable throwable, String messageTemplate, Object... params) {
        super(StrUtil.format(messageTemplate, params), throwable);
    }
}
