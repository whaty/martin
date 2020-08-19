package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.Operation;
import com.java2e.martin.biz.system.mapper.OperationMapper;
import com.java2e.martin.biz.system.service.OperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java2e.martin.common.data.mybatis.service.impl.MartinServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统操作 服务实现类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Service
public class OperationServiceImpl extends MartinServiceImpl<OperationMapper, Operation> implements OperationService {

    @Override
    public void generateDefaultOperation(Object id) {
        baseMapper.generateDefaultOperation(id);
    }

    @Override
    protected void setEntity() {
        this.clz = Operation.class;
    }
}
