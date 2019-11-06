package com.java2e.martin.common.security.util;

import com.java2e.martin.common.security.userdetail.MartinUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Set;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/10/25
 * @Describtion: SecurityContextUtil
 */
@UtilityClass
public class SecurityContextUtil {

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public Set<String> getAuthorities() {
        return AuthorityUtils.authorityListToSet(getAuthentication().getAuthorities());
    }

    public User getUser(){
        return (User) getAuthentication().getPrincipal();
    }
}
