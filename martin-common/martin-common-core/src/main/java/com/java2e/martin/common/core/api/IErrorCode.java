package com.java2e.martin.common.core.api;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/8/22
 * @Describtion: IErrorCode 接口返回统一错误接口
 */
public interface IErrorCode {
    /**
     * 获取错误码
     *
     * @return long
     */
    long getCode();

    /**
     * 获取错误信息
     *
     * @return String
     */
    String getMsg();
}
