package com.java2e.martin.common.api.resource;

import com.java2e.martin.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/7/30
 * @Describtion: RemoteResource,resource 模块对外提供的示例服务
 */
@FeignClient(name = ServiceNameConstants.MARTIN_BIZ_RESOURCE_SERVICE)
public interface RemoteResource {
    @GetMapping("/test")
    String test();
}
