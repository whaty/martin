package com.java2e.martin.common.api.system;

import com.java2e.martin.common.bean.system.Log;
import com.java2e.martin.common.core.api.R;
import com.java2e.martin.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 狮少
 * @version 1.0
 * @date 2020/9/18
 * @describtion RemoteSystemLog
 * @since 1.0
 */
@FeignClient(contextId = "remoteSystemLog", name = ServiceNameConstants.MARTIN_BIZ_SYSTEM_SERVICE)
public interface RemoteSystemLog {
    /**
     * 插入系统操作日志
     *
     * @param log
     * @return
     */
    @PostMapping("/log/add")
    R addSystemLog(@RequestBody Log log);
}
