package com.java2e.martin.common.security.service;

import lombok.Getter;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/5/29 10:35
 * @Describtion: 扩展auth2.0用户信息
 */
public class MartinUser extends User {
    /**
     * 用户ID
     */
    @Getter
    private Integer id;
    /**
     * 部门ID
     */
    @Getter
    private Integer deptId;

    /**
     * 租户ID
     */
    @Getter
    private Integer tenantId;

    /**
     * Construct the <code>User</code> with the details required by
     * {@link DaoAuthenticationProvider}.
     *
     * @param id                    用户ID
     * @param deptId                部门ID
     * @param tenantId              租户ID
     * @param username              the username presented to the
     *                              <code>DaoAuthenticationProvider</code>
     * @param password              the password that should be presented to the
     *                              <code>DaoAuthenticationProvider</code>
     * @param enabled               set to <code>true</code> if the user is enabled
     * @param accountNonExpired     set to <code>true</code> if the account has not expired
     * @param credentialsNonExpired set to <code>true</code> if the credentials have not
     *                              expired
     * @param accountNonLocked      set to <code>true</code> if the account is not locked
     * @param authorities           the authorities that should be granted to the caller if they
     *                              presented the correct username and password and the user is enabled. Not null.
     * @throws IllegalArgumentException if a <code>null</code> value was passed either as
     *                                  a parameter or as an element in the <code>GrantedAuthority</code> collection
     */
    public MartinUser(Integer id, Integer deptId, Integer tenantId, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
        this.deptId = deptId;
        this.tenantId = tenantId;
    }
}
