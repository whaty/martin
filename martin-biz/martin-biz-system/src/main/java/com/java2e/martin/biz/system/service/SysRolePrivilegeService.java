package com.java2e.martin.biz.system.service;

import com.java2e.martin.common.bean.system.SysRolePrivilege;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 系统角色权限关系 服务类
 * </p>
 *
 * @author liangcan
 * @since 2019-09-19
 */
@Transactional(rollbackFor = Exception.class)
public interface SysRolePrivilegeService extends IService<SysRolePrivilege> {

}
