package com.java2e.martin.biz.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java2e.martin.common.bean.system.SysPrivilege;
import com.java2e.martin.common.bean.system.SysUserRole;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional(rollbackFor = Exception.class)
public interface SysPrivilegeService extends IService<SysPrivilege> {

    /**
     * 通过角色获取权限
     *
     * @param roleList
     * @return
     */
    Set<String> getPrivilegeByRoles(List<SysUserRole> roleList);
}
