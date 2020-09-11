package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.Menu;
import com.java2e.martin.biz.system.mapper.MenuMapper;
import com.java2e.martin.biz.system.service.MenuService;
import com.java2e.martin.common.bean.system.Role;
import com.java2e.martin.common.bean.system.dto.MenuTreeNode;
import com.java2e.martin.common.bean.system.vo.RoleMenuTreeVo;
import com.java2e.martin.common.bean.util.TreeUtil;
import com.java2e.martin.common.core.constant.CommonConstants;
import com.java2e.martin.common.data.mybatis.service.impl.MartinServiceImpl;
import com.java2e.martin.common.security.util.SecurityContextUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 系统菜单 服务实现类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Service
public class MenuServiceImpl extends MartinServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public List<Menu> getAllUiMenu() {
        return baseMapper.getAllUiMenu();
    }

    @Override
    public Object insert(Menu menu) {
        return baseMapper.insert(menu);
    }

    @Override
    public List<MenuTreeNode> getCurrentUserMenusByRoles() {
        Set<Integer> roleIds = SecurityContextUtil.getUser().getRoleIds();
        List<Menu> list = baseMapper.getCurrentUserMenusByRoles(roleIds);
        HashMap<Integer, Menu> map = new HashMap<>();
        for (Menu menu : list) {
            map.put(menu.getId(), menu);
        }
        for (int i = 0; i < list.size(); i++) {
            Integer parentId = list.get(i).getParentId();
            if (parentId == CommonConstants.MENU_ROOT) {
                list.get(i).setParentKey("/");
            } else {
                list.get(i).setParentKey(map.get(parentId).getPath());
            }
        }
        List<MenuTreeNode> routes = TreeUtil.buildRoutesByRecursive(list, CommonConstants.MENU_ROOT);
        return routes;
    }

    @Override
    public HashMap<String, Object> getAllMenuByRole(Role role) {
        List<Menu> menus = baseMapper.getAllMenus();
        List<Menu> selectMenus = baseMapper.getSelectMenus(role);
        List<RoleMenuTreeVo> roleMenuTreeVos = TreeUtil.buildRoleMenusByMenus(menus, CommonConstants.MENU_ROOT);
        List<String> defaultSelectedKeys = new ArrayList<>();
        selectMenus.stream().forEach(m -> defaultSelectedKeys.add(m.getId().toString()));
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("treeData", roleMenuTreeVos);
        map.put("defaultSelectedKeys", defaultSelectedKeys);
        return map;
    }

    @Override
    public List getAllMenuTree() {
        List<Menu> list = this.list();
        List<MenuTreeNode> menuTree = TreeUtil.buildRoutesByRecursive(list, CommonConstants.MENU_ROOT);
        return menuTree;
    }

    @Override
    protected void setEntity() {
        this.clz = Menu.class;
    }
}
