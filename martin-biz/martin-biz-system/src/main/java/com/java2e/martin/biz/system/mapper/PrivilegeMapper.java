package com.java2e.martin.biz.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java2e.martin.common.bean.system.Privilege;
import com.java2e.martin.common.bean.system.UserRole;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 系统权限 Mapper 接口
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
public interface PrivilegeMapper extends BaseMapper<Privilege> {
    /**
     * 通过角色获取权限
     *
     * @param roleList
     * @return
     */
    Set<String> getPrivilegeByRoles(List<UserRole> roleList);
}
