package com.java2e.martin.biz.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java2e.martin.common.bean.system.Operation;

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
     * 判定表在数据库是否存在
     *
     * @param tableName
     * @return
     */
    int isTableExits(String tableName);
}
