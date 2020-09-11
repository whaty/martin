package com.java2e.martin.biz.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java2e.martin.common.bean.system.Config;
import com.java2e.martin.common.data.mybatis.service.MartinService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 狮少
 * @date 2020-07-24
 */
@Transactional(rollbackFor = Exception.class)
public interface ConfigService extends MartinService<Config> {

}
