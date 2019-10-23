package com.java2e.martin.biz.system.service;

import com.java2e.martin.common.bean.system.DeptRole;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 系统部门角色关系 服务类
 * </p>
 *
 * @author liangcan
 * @since 2019-10-18
 */
@Transactional(rollbackFor = Exception.class)
public interface DeptRoleService extends IService<DeptRole> {

}
