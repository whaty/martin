package com.java2e.martin.biz.system.mapper;

import com.java2e.martin.common.bean.system.Operation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 系统操作 Mapper 接口
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
public interface OperationMapper extends BaseMapper<Operation> {

    /**
     * 为菜单生成默认的增删改查按钮
     *
     * @param id
     */
    void generateDefaultOperation(Object id);
}
