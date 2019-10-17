package com.java2e.martin.biz.system.service;

import com.java2e.martin.common.bean.system.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author liangcan
 * @since 2019-09-11
 */
@Transactional(rollbackFor = Exception.class)
public interface SysUserService extends IService<SysUser> {

}
