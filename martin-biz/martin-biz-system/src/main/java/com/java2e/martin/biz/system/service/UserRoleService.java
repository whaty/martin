package com.java2e.martin.biz.system.service;

import com.java2e.martin.common.bean.system.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 系统用户角色关系 服务类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Transactional(rollbackFor = Exception.class)
public interface UserRoleService extends IService<UserRole> {

}
