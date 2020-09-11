package com.java2e.martin.common.security.util;

import com.java2e.martin.common.security.userdetail.MartinUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Set;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/10/25
 * @describtion SecurityContextUtil
 * @since 1.0
 */
@UtilityClass
public class SecurityContextUtil {

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public Set<String> getAuthorities() {
        return AuthorityUtils.authorityListToSet(getAuthentication().getAuthorities());
    }

    public MartinUser getUser() {
        return (MartinUser) getAuthentication().getPrincipal();
    }
}
