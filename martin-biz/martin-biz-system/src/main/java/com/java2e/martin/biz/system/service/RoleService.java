package com.java2e.martin.biz.system.service;

import com.java2e.martin.biz.system.vo.RoleCheckbox;
import com.java2e.martin.common.bean.system.Role;
import com.java2e.martin.common.bean.system.User;
import com.java2e.martin.common.bean.system.vo.RoleOperationVo;
import com.java2e.martin.common.data.mybatis.service.MartinService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统角色 服务类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Transactional(rollbackFor = Exception.class)
public interface RoleService extends MartinService<Role> {

    /**
     * 获取系统全部角色
     *
     * @return
     */
    List<RoleCheckbox> getAllRoles();

    /**
     * 获取当前用户已分配角色
     *
     * @param user
     * @param id
     * @return
     */
    List<RoleCheckbox> getSelectRoles(User id);

    /**
     * 根据选中角色的菜单信息，获取按钮信息
     *
     * @param map
     * @return
     */
    List<RoleOperationVo> getOperationByCheckedMenus(Map map);
}
