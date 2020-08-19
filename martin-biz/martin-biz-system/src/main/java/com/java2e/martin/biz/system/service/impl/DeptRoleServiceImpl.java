package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.DeptRole;
import com.java2e.martin.biz.system.mapper.DeptRoleMapper;
import com.java2e.martin.biz.system.service.DeptRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java2e.martin.common.data.mybatis.service.impl.MartinServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统部门角色关系 服务实现类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Service
public class DeptRoleServiceImpl extends MartinServiceImpl<DeptRoleMapper, DeptRole> implements DeptRoleService {

    @Override
    protected void setEntity() {
        this.clz = DeptRole.class;
    }
}
