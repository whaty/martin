package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.DeptUser;
import com.java2e.martin.biz.system.mapper.DeptUserMapper;
import com.java2e.martin.biz.system.service.DeptUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户部门关系 服务实现类
 * </p>
 *
 * @author liangcan
 * @since 2019-10-18
 */
@Service
public class DeptUserServiceImpl extends ServiceImpl<DeptUserMapper, DeptUser> implements DeptUserService {

}
