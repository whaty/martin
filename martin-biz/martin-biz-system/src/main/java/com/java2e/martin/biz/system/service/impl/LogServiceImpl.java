package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.Log;
import com.java2e.martin.biz.system.mapper.LogMapper;
import com.java2e.martin.biz.system.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author liangcan
 * @since 2019-10-18
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
