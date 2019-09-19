package com.java2e.martin.biz.system.mapper;

import com.java2e.martin.common.bean.system.SysPrivilege;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java2e.martin.common.bean.system.SysUserRole;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 系统权限 Mapper 接口
 * </p>
 *
 * @author liangcan
 * @since 2019-09-11
 */
public interface SysPrivilegeMapper extends BaseMapper<SysPrivilege> {

    Set<String> getPrivilegeByRoles(List<SysUserRole> roleList);
}
