package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.SysUser;
import com.java2e.martin.biz.system.mapper.SysUserMapper;
import com.java2e.martin.biz.system.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author liangcan
 * @since 2019-09-11
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
