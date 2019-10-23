package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.User;
import com.java2e.martin.biz.system.mapper.UserMapper;
import com.java2e.martin.biz.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author liangcan
 * @since 2019-10-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
