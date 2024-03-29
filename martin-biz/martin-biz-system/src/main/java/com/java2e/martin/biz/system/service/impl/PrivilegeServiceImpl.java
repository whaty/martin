package com.java2e.martin.biz.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.java2e.martin.biz.system.mapper.PrivilegeMapper;
import com.java2e.martin.biz.system.service.PrivilegeService;
import com.java2e.martin.common.bean.system.Privilege;
import com.java2e.martin.common.bean.system.UserRole;
import com.java2e.martin.common.data.mybatis.service.impl.MartinServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 系统权限 服务实现类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Service
public class PrivilegeServiceImpl extends MartinServiceImpl<PrivilegeMapper, Privilege> implements PrivilegeService {
    @Override
    public Set<String> getPrivilegeByRoles(List<UserRole> roleList) {
        return this.baseMapper.getPrivilegeByRoles(roleList);
    }

    @Override
    public Boolean saveCheckedMenus(Map map) {
        Integer roleId = (Integer) map.get("roleId");
        if (roleId != null) {
            this.baseMapper.deleteOldMenus(map);
        }
        Object checkedKeys = map.get("checkedKeys");
        if (checkedKeys instanceof Map) {
            List checked = null;
            if (CollUtil.isNotEmpty((Map) checkedKeys)) {
                checked = (List) ((Map) checkedKeys).get("checked");
                if (CollUtil.isNotEmpty(checked)) {
                    map.put("checked", checked);
                    this.baseMapper.saveCheckedMenus(map);
                } else {
                    return Boolean.FALSE;
                }
            } else {
                return Boolean.FALSE;
            }
        } else if (checkedKeys instanceof List) {
            if (CollUtil.isNotEmpty((List) checkedKeys)) {
                map.put("checked", checkedKeys);
                this.baseMapper.saveCheckedMenus(map);
            } else {
                return Boolean.FALSE;
            }
        } else {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean saveCheckedOperations(Map map) {
        Integer roleId = (Integer) map.get("roleId");
        if (roleId != null) {
            this.baseMapper.deleteOldOperations(map);
        }
        List checkedKeys = (List) map.get("checkedKeys");
        if (CollUtil.isNotEmpty(checkedKeys)) {
            this.baseMapper.saveCheckedOperations(map);
        }
        return Boolean.TRUE;
    }

    @Override
    protected void setEntity() {
        this.clz = Privilege.class;
    }
}
