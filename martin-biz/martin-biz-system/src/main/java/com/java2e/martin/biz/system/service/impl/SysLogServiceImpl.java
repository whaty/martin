package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.SysLog;
import com.java2e.martin.biz.system.mapper.SysLogMapper;
import com.java2e.martin.biz.system.service.SysLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author liangcan
 * @since 2019-09-11
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

}
