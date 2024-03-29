package com.java2e.martin.biz.system.service;

import com.java2e.martin.common.bean.system.Log;
import com.baomidou.mybatisplus.extension.service.IService;
import com.java2e.martin.common.data.mybatis.service.MartinService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 系统日志 服务类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public interface LogService extends MartinService<Log> {

}
