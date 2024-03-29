package com.java2e.martin.biz.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java2e.martin.common.bean.system.Privilege;
import com.java2e.martin.common.bean.system.UserRole;
import com.java2e.martin.common.data.mybatis.service.MartinService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 系统权限 服务类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Transactional(rollbackFor = Exception.class)
public interface PrivilegeService extends MartinService<Privilege> {
    /**
     * 通过角色获取权限
     *
     * @param roleList
     * @return
     */
    Set<String> getPrivilegeByRoles(List<UserRole> roleList);

    /**
     * 更新角色的菜单信息，先删除原来的，再插入新的
     *
     * @param map
     * @return
     */
    Boolean saveCheckedMenus(Map map);

    /**
     * 更新角色的按钮信息，先删除原来的，再插入新的
     *
     * @param map
     * @return
     */
    Boolean saveCheckedOperations(Map map);
}
