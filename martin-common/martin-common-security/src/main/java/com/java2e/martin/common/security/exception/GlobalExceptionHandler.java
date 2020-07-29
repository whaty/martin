package com.java2e.martin.common.security.exception;

import com.java2e.martin.common.core.api.ApiErrorCode;
import com.java2e.martin.common.core.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/10/17
 * @describtion GlobalExceptionHandler
 * @since 1.0
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error("", e);
        return R.failed(ApiErrorCode.FAILED);
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public R defaultErrorHandler(HttpServletRequest req, AccessDeniedException e) throws Exception {
        log.error("", e);
        return R.failed(ApiErrorCode.UNAUTHORIZED);
    }

}
