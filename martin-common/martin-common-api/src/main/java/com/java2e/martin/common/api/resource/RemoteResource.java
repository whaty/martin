package com.java2e.martin.common.api.resource;

import com.java2e.martin.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/7/30
 * @describtion RemoteResource, resource 模块对外提供的示例服务
 * @since 1.0
 */
@FeignClient(contextId = "remoteResource", name = ServiceNameConstants.MARTIN_BIZ_RESOURCE_SERVICE)
public interface RemoteResource {
    @GetMapping("/test")
    String test();
}
