package com.java2e.martin.biz.system.mapper;

import com.java2e.martin.biz.system.vo.RoleCheckbox;
import com.java2e.martin.common.bean.system.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java2e.martin.common.bean.system.User;
import com.java2e.martin.common.bean.system.vo.MenuOperationVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统角色 Mapper 接口
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 获取系统所有角色
     *
     * @return
     */
    List<RoleCheckbox> getAllRoles();

    /**
     * 获取当前用户已分配角色
     *
     * @param user
     * @return
     */
    List<RoleCheckbox> getSelectRoles(User user);

    /**
     * 获取所选菜单的所有按钮
     *
     * @param map
     * @return
     */
    List<MenuOperationVo> getALlOperationsByMenus(Map map);

    /**
     * 获取所选菜单的已选按钮
     *
     * @param map
     * @return
     */
    List<MenuOperationVo> getCheckedOperationsByMenus(Map map);
}
