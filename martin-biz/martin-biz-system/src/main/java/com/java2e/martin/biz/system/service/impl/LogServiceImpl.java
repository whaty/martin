package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.Log;
import com.java2e.martin.biz.system.mapper.LogMapper;
import com.java2e.martin.biz.system.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java2e.martin.common.data.mybatis.service.impl.MartinServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Service
public class LogServiceImpl extends MartinServiceImpl<LogMapper, Log> implements LogService {

    @Override
    protected void setEntity() {
        this.clz = Log.class;
    }
}
