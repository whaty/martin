package com.java2e.martin.common.security.exception;

import com.java2e.martin.common.core.api.ApiErrorCode;
import com.java2e.martin.common.core.api.R;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R defaultErrorHandler(HttpServletRequest req, MethodArgumentNotValidException e) throws Exception {
        log.error("", e);
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        List<Map> errorMsgs = new ArrayList<>();

        allErrors.forEach(objectError -> {
            HashMap<Object, Object> errorMsg = new HashMap<>(3);
            FieldError fieldError = (FieldError) objectError;
            errorMsg.put("field", fieldError.getField());
            errorMsg.put("objectName", fieldError.getObjectName());
            errorMsg.put("message", fieldError.getDefaultMessage());
            errorMsgs.add(errorMsg);
        });
        return R.restResult(errorMsgs, ApiErrorCode.FAILED);
    }


}
