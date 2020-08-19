package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.Dict;
import com.java2e.martin.biz.system.mapper.DictMapper;
import com.java2e.martin.biz.system.service.DictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java2e.martin.common.data.mybatis.service.impl.MartinServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统字典 服务实现类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Service
public class DictServiceImpl extends MartinServiceImpl<DictMapper, Dict> implements DictService {

    @Override
    protected void setEntity() {
        this.clz = Dict.class;
    }
}
