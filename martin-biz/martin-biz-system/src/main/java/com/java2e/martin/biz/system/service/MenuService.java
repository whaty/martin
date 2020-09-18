package com.java2e.martin.biz.system.service;

import com.java2e.martin.common.bean.system.Menu;
import com.java2e.martin.common.bean.system.Role;
import com.java2e.martin.common.bean.system.dto.MenuTreeNode;
import com.java2e.martin.common.data.mybatis.service.MartinService;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 系统菜单 服务类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Transactional(rollbackFor = Exception.class)
public interface MenuService extends MartinService<Menu> {

    /**
     * 获取所有ui所需要的菜单信息
     *
     * @return List<Menu>
     */
    List<Menu> getAllUiMenu();

    /**
     * 插入Menu并返回主键
     *
     * @param menu
     * @return
     */
    Object insert(Menu menu);

    /**
     * 获取当前登录用户所的有菜单
     *
     * @param roleIds
     * @return
     */
    List<MenuTreeNode> getCurrentUserMenusByRoles();

    /**
     * 角色分配菜单时，获取所有已分配菜单和所有菜单集合
     *
     * @param role
     * @return
     */
    HashMap<String, Object> getAllMenuByRole(Role role);

    /**
     * 获取系统所有菜单，并生成树结构
     *
     * @return
     */
    List getAllMenuTree();

}
