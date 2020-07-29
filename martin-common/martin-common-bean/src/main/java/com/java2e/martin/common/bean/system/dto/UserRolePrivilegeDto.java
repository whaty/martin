package com.java2e.martin.common.bean.system.dto;

import com.java2e.martin.common.bean.system.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/9/5
 * @describtion UserRolePrivilegeDto，传输给前端的权限，包含 菜单/操作/文件/元素 四类权限，后续可以自由扩展
 * @since 1.0
 */
@Data
public class UserRolePrivilegeDto implements Serializable {

    private static final long serialVersionUID = -74188199181458373L;
    /**
     * 当前用户所有信息
     */
    private User user;

    /**
     * 角色信息
     */
    private Set<Integer> roles;

    /**
     * 菜单权限
     */
    private Set<String> menus;

    /**
     * 操作权限
     */
    private Set<String> operations;

    /**
     * 文件权限
     */
    private Set<String> files;

    /**
     * 页面元素权限
     */
    private Set<String> elements;

    /**
     * 所有权限
     */
    private Set<String> authoritySet;

    /**
     * 返给前端的集合，包含 菜单/操作/文件/元素 四类权限，后续可以自由扩展
     */
    private Map<String, Set> map;

}
