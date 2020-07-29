package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.Role;
import com.java2e.martin.biz.system.mapper.RoleMapper;
import com.java2e.martin.biz.system.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统角色 服务实现类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
