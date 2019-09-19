package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.SysPrivilege;
import com.java2e.martin.biz.system.mapper.SysPrivilegeMapper;
import com.java2e.martin.biz.system.service.SysPrivilegeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java2e.martin.common.bean.system.SysUserRole;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 系统权限 服务实现类
 * </p>
 *
 * @author liangcan
 * @since 2019-09-11
 */
@Service
public class SysPrivilegeServiceImpl extends ServiceImpl<SysPrivilegeMapper, SysPrivilege> implements SysPrivilegeService {

    @Override
    public Set<String> getPrivilegeByRoles(List<SysUserRole> roleList) {
        return this.baseMapper.getPrivilegeByRoles(roleList);
    }
}
