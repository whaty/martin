package com.java2e.martin.common.security.userdetail;

import cn.hutool.core.util.StrUtil;
import com.java2e.martin.common.api.system.RemoteSystem;
import com.java2e.martin.common.bean.system.User;
import com.java2e.martin.common.bean.system.dto.UserRolePrivilegeDto;
import com.java2e.martin.common.core.api.ApiErrorCode;
import com.java2e.martin.common.core.api.R;
import com.java2e.martin.common.core.constant.CacheConstants;
import com.java2e.martin.common.core.constant.CommonConstants;
import com.java2e.martin.common.core.exception.StatefulException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.Set;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/9/2
 * @Describtion: MartinUserDetailsService
 */
@Slf4j
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
        R<UserRolePrivilegeDto> r = remoteSystem.loadUserByUsername(username);
        return getUserDetails(r);
    }

    private UserDetails getUserDetails(R<UserRolePrivilegeDto> r) {
        UserRolePrivilegeDto userRolePrivilegeDto = r.getData();
        log.debug("loadUserByUsername :{},{}", r.getCode(), r.getMsg());
        if (null == userRolePrivilegeDto) {
            log.error("{}", ApiErrorCode.USERNOTFIND);
            throw new StatefulException(ApiErrorCode.USERNOTFIND);
        }
        User sysUser = userRolePrivilegeDto.getUser();

        Set<String> authoritySet = userRolePrivilegeDto.getAuthoritySet();
        log.debug("authoritySet : {}", authoritySet);
        Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(authoritySet.toArray(new String[0]));

        boolean enabled = StrUtil.equals(sysUser.getDelFlag(), CommonConstants.STATUS_NORMAL);
        boolean accountNonLocked = !StrUtil.equals(sysUser.getLockFlag(), CommonConstants.STATUS_LOCK);
        MartinUser martinUser = new MartinUser(sysUser.getId(), sysUser.getDeptId(), sysUser.getTenantId(), sysUser.getUsername(), sysUser.getPwd(), enabled, true, true, accountNonLocked, authorities);
        return martinUser;
    }
}
