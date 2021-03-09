package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.User;
import com.java2e.martin.biz.system.mapper.UserMapper;
import com.java2e.martin.biz.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java2e.martin.common.core.api.R;
import com.java2e.martin.common.data.mybatis.service.impl.MartinServiceImpl;
import com.java2e.martin.common.security.userdetail.MartinUser;
import com.java2e.martin.common.security.util.SecurityContextUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Service
public class UserServiceImpl extends MartinServiceImpl<UserMapper, User> implements UserService {

    @Override
    protected void setEntity() {
        this.clz = User.class;
    }

    @Override
    public R currentUser() {
        MartinUser user = SecurityContextUtil.getUser();
        return R.ok(this.baseMapper.currentUser(user.getId()));
    }
}
