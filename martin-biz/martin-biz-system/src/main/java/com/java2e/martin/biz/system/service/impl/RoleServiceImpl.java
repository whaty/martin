package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.biz.system.mapper.RoleMapper;
import com.java2e.martin.biz.system.service.RoleService;
import com.java2e.martin.biz.system.vo.RoleCheckbox;
import com.java2e.martin.common.bean.system.Role;
import com.java2e.martin.common.bean.system.User;
import com.java2e.martin.common.bean.system.vo.MenuOperationVo;
import com.java2e.martin.common.bean.system.vo.RoleOperationVo;
import com.java2e.martin.common.data.mybatis.service.impl.MartinServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统角色 服务实现类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Service
public class RoleServiceImpl extends MartinServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    protected void setEntity() {
        this.clz = Role.class;
    }

    @Override
    public List<RoleCheckbox> getAllRoles() {
        return baseMapper.getAllRoles();
    }

    @Override
    public List<RoleCheckbox> getSelectRoles(User user) {
        return baseMapper.getSelectRoles(user);
    }

    @Override
    public List<RoleOperationVo> getOperationByCheckedMenus(Map map) {
        //获取所选菜单的所有按钮
        List<MenuOperationVo> allOperationsByMenus = baseMapper.getALlOperationsByMenus(map);
        //获取所选菜单的已选按钮
        List<MenuOperationVo> checkedOperationsByMenus = baseMapper.getCheckedOperationsByMenus(map);

        Map<String, List<MenuOperationVo>> groupMenus = allOperationsByMenus.stream().collect(Collectors.groupingBy(MenuOperationVo::getMenuName));

        List<RoleOperationVo> returnList = new LinkedList<>();
        groupMenus.forEach((k, v) -> {
            RoleOperationVo roleOperationVo = new RoleOperationVo();
            List<Integer> defaultValue = new LinkedList<>();
            List operations = new LinkedList<>();
            v.stream().forEach((allOperation) -> {
                        checkedOperationsByMenus.stream().forEach((checkedOperation) -> {
                            if (allOperation.getValue().equals(checkedOperation.getValue())) {
                                defaultValue.add(checkedOperation.getValue());
                            }
                        });
                        RoleOperationVo.OperationVo operationVo = roleOperationVo.new OperationVo();
                        operationVo.setName(allOperation.getName());
                        operationVo.setValue(allOperation.getValue());
                        operations.add(operationVo);
                    }
            );
            roleOperationVo.setMenuName(k);
            roleOperationVo.setDefaultValue(defaultValue);
            roleOperationVo.setOperations(operations);
            returnList.add(roleOperationVo);
        });

        return returnList;
    }


}
