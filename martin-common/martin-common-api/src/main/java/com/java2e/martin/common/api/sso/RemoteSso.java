package com.java2e.martin.common.api.sso;

import com.java2e.martin.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/7/30
 * @describtion RemoteSso ,sso 模块对外提供的示例服务
 * @since 1.0
 */
@FeignClient(name = ServiceNameConstants.MARTIN_BIZ_SSO_SERVICE)
public interface RemoteSso {

}
