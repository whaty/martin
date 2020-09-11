package com.java2e.martin.biz.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java2e.martin.biz.system.mapper.ConfigMapper;
import com.java2e.martin.biz.system.service.ConfigService;
import com.java2e.martin.common.bean.system.Config;
import com.java2e.martin.common.data.mybatis.service.impl.MartinServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 狮少
 * @date 2020-07-24
 */
@Service
public class ConfigServiceImpl extends MartinServiceImpl<ConfigMapper, Config> implements ConfigService {

    @Override
    protected void setEntity() {
        this.clz = Config.class;
    }
}
