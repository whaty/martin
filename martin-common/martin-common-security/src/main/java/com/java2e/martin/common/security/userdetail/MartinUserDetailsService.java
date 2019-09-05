package com.java2e.martin.common.security.userdetail;

import cn.hutool.core.bean.BeanUtil;
import com.java2e.martin.common.api.system.RemoteSystem;
import com.java2e.martin.common.core.constant.CacheConstants;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/9/2
 * @Describtion: MartinUserDetailsService
 */
public class MartinUserDetailsService implements UserDetailsService {
    @Autowired
    private RemoteSystem remoteSystem;

    /**
     * 获取用户、权限、菜单
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    @SneakyThrows
    @Cacheable(value = CacheConstants.USER_DETAILS, key = "#username", unless = "#result == null")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Map map = remoteSystem.loadUserByUsername(username);
        MartinUser martinUser = BeanUtil.mapToBean(map, MartinUser.class, true);
        return martinUser;
    }
}
