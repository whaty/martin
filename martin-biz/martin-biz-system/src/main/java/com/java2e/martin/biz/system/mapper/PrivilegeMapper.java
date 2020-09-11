package com.java2e.martin.biz.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java2e.martin.common.bean.system.Privilege;
import com.java2e.martin.common.bean.system.UserRole;

import java.util.List;
import java.util.Map;
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

    /**
     * 先删除原来的角色菜单
     *
     * @param map
     * @return
     */
    Boolean deleteOldMenus(Map map);

    /**
     * 插入角色新菜单信息
     *
     * @param map
     * @return
     */
    Boolean saveCheckedMenus(Map map);


    /**
     * 先删除原来的角色按钮
     *
     * @param map
     * @return
     */
    Boolean deleteOldOperations(Map map);

    /**
     * 插入角色新按钮信息
     *
     * @param map
     * @return
     */
    Boolean saveCheckedOperations(Map map);
}
