package com.java2e.martin.biz.system.service;

import com.java2e.martin.common.bean.system.SysPrivilege;
import com.baomidou.mybatisplus.extension.service.IService;
import com.java2e.martin.common.bean.system.SysUserRole;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 系统权限 服务类
 * </p>
 *
 * @author liangcan
 * @since 2019-09-11
 */
public interface SysPrivilegeService extends IService<SysPrivilege> {

    Set<String> getPrivilegeByRoles(List<SysUserRole> roleList);
}
