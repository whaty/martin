package com.java2e.martin.common.security.userdetail;

import lombok.Getter;
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

    public MartinUser(Integer id, Integer deptId, Integer tenantId, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
        this.deptId = deptId;
        this.tenantId = tenantId;
    }
}
