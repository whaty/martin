package com.java2e.martin.common.api.sso;

import com.java2e.martin.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/7/30
 * @Describtion: RemoteSso ,sso 模块对外提供的示例服务
 */
@FeignClient(name = ServiceNameConstants.MARTIN_BIZ_SSO_SERVICE)
public interface RemoteSso {

}
