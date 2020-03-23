package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.Privilege;
import com.java2e.martin.biz.system.mapper.PrivilegeMapper;
import com.java2e.martin.biz.system.service.PrivilegeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java2e.martin.common.bean.system.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 系统权限 服务实现类
 * </p>
 *
 * @author liangcan
 * @since 2019-10-18
 */
@Service
public class PrivilegeServiceImpl extends ServiceImpl<PrivilegeMapper, Privilege> implements PrivilegeService {
    @Override
    public Set<String> getPrivilegeByRoles(List<UserRole> roleList) {
        return this.baseMapper.getPrivilegeByRoles(roleList);
    }
}