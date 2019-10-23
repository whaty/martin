package com.java2e.martin.biz.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java2e.martin.common.bean.system.Privilege;
import com.java2e.martin.common.bean.system.UserRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 系统权限 服务类
 * </p>
 *
 * @author liangcan
 * @since 2019-10-18
 */
@Transactional(rollbackFor = Exception.class)
public interface PrivilegeService extends IService<Privilege> {
    /**
     * 通过角色获取权限
     *
     * @param roleList
     * @return
     */
    Set<String> getPrivilegeByRoles(List<UserRole> roleList);
}
