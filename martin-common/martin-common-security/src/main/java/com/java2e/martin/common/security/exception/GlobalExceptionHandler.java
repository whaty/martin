package com.java2e.martin.common.security.exception;

import com.java2e.martin.common.core.api.ApiErrorCode;
import com.java2e.martin.common.core.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/10/17
 * @Describtion: GlobalExceptionHandler
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error("", e);
        return R.failed(ApiErrorCode.FAILED);
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseBody
    public R defaultErrorHandler(HttpServletRequest req, AccessDeniedException e) throws Exception {
        log.error("", e);
        return R.failed(ApiErrorCode.UNAUTHORIZED);
    }

}
