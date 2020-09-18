package com.java2e.martin.biz.system.service;

import com.java2e.martin.common.bean.system.Menu;
import com.java2e.martin.common.bean.system.Operation;
import com.java2e.martin.common.core.api.R;
import com.java2e.martin.common.data.mybatis.service.MartinService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 系统操作 服务类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Transactional(rollbackFor = Exception.class)
public interface OperationService extends MartinService<Operation> {
    /**
     * 生成菜单CRUD按钮
     *
     * @param menu
     * @return
     */
    R generateOperation(Menu menu);

    /**
     * 判定表在数据库是否存在
     *
     * @param tableName
     * @return
     */
    boolean isTableExits(String tableName);
}
