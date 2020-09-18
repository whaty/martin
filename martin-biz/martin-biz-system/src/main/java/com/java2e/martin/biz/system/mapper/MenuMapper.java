package com.java2e.martin.biz.system.mapper;

import com.java2e.martin.common.bean.system.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java2e.martin.common.bean.system.Role;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 系统菜单 Mapper 接口
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 获取所有ui所需要的菜单信息
     *
     * @return List<Menu>
     */
    List<Menu> getAllUiMenu();

    /**
     * 角色分配菜单时，获取所有菜单
     *
     * @return
     */
    List<Menu> getAllMenus();

    /**
     * 角色分配菜单时，获取所有已分配菜单
     *
     * @param role
     * @return
     */
    List<Menu> getSelectMenus(Role role);

    /**
     * 获取当前登录用户所的有菜单
     *
     * @param roleIds
     * @return
     */
    List<Menu> getCurrentUserMenusByRoles(Set<Integer> roleIds);

    /**
     * 生成菜单CRUD按钮
     *
     * @param menu
     * @return
     */
    Object generateOperation(Menu menu);

}
