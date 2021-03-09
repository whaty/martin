package com.java2e.martin.biz.system.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.java2e.martin.biz.system.vo.RoleCheckbox;
import com.java2e.martin.biz.system.service.PrivilegeService;
import com.java2e.martin.biz.system.service.RoleService;
import com.java2e.martin.biz.system.service.UserRoleService;
import com.java2e.martin.biz.system.service.UserService;
import com.java2e.martin.common.bean.system.User;
import com.java2e.martin.common.bean.system.UserRole;
import com.java2e.martin.common.bean.system.vo.UserRolePrivilegeVo;
import com.java2e.martin.common.core.api.ApiErrorCode;
import com.java2e.martin.common.core.api.R;
import com.java2e.martin.common.core.constant.SecurityConstants;
import com.java2e.martin.common.log.annotation.MartinLog;
import com.java2e.martin.common.security.userdetail.MartinUser;
import com.java2e.martin.common.security.util.SecurityContextUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("user")
@Api(value = "User 控制器", tags = "系统用户")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private PrivilegeService privilegeService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     * 添加
     *
     * @param user User
     * @return R
     */
    @MartinLog("添加系统用户")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_user_add')")
    public R save(@Valid @RequestBody User user) {
        String pwd = user.getPwd();
        if (StrUtil.isNotBlank(pwd)) {
            user.setPwd(SecurityConstants.BCRYPT + bCryptPasswordEncoder.encode(pwd));
        }
        return R.ok(userService.save(user));
    }

    /**
     * 删除
     *
     * @param user User
     * @return R
     */
    @MartinLog("删除系统用户")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_user_del')")
    public R removeById(@Valid @RequestBody User user) {
        return R.ok(userService.removeById(user.getId()));
    }

    /**
     * 编辑
     *
     * @param user User
     * @return R
     */
    @MartinLog("编辑系统用户")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys_user_edit')")
    public R update(@Valid @RequestBody User user) {
        String pwd = user.getPwd();
        if (StrUtil.isNotBlank(pwd)) {
            user.setPwd(SecurityConstants.BCRYPT + bCryptPasswordEncoder.encode(pwd));
        }
        return R.ok(userService.updateById(user));
    }

    /**
     * 通过ID查询
     *
     * @param user User
     * @return R
     */
    @MartinLog("单个查询系统用户")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_user_get')")
    public R getById(@RequestBody User user) {
        return R.ok(userService.getById(user.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统用户")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_user_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        try {
            return R.ok(userService.getPage(params));
        } catch (IllegalAccessException e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        } catch (InstantiationException e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        }
    }

    @MartinLog("批量删除系统用户")
    @PostMapping("/deleteBatch")
    @PreAuthorize("hasAuthority('sys_user_deleteBatch')")
    public R removeBatch(@RequestBody String ids) {
        List<String> idList = Arrays.stream(ids.split(",")).collect(Collectors.toList());
        if (CollUtil.isEmpty(idList)) {
            return R.failed("id 不能为空");
        }
        return R.ok(userService.removeByIds(idList));
    }

    @GetMapping("/loadUserByUsername/{username}")
    public R<UserRolePrivilegeVo> loadUserByUsername(@PathVariable String username) {
        UserRolePrivilegeVo userRolePrivilegeVo = new UserRolePrivilegeVo();
        User user = userService.getOne(Wrappers.<User>query().lambda().eq(User::getUsername, username));
        log.debug("{}", Convert.toStr(user));
        if (null == user) {
            return R.failed(ApiErrorCode.USER_NOT_FOUND);
        }
        userRolePrivilegeVo.setUser(user);
        List<UserRole> roleList = userRoleService.list(Wrappers.<UserRole>query().lambda().eq(UserRole::getUserId, user.getId()));
        if (CollectionUtil.isEmpty(roleList)) {
            log.error("{}", R.failed(ApiErrorCode.ROLE_NOT_FOUND));
            return R.failed(ApiErrorCode.ROLE_NOT_FOUND);
        }
        Map<Integer, List<UserRole>> roles = roleList.stream().collect(Collectors.groupingBy(UserRole::getRoleId));
        userRolePrivilegeVo.setRoles(roles.keySet());
        Set<String> authoritySet = privilegeService.getPrivilegeByRoles(roleList);
        if (CollectionUtil.isEmpty(authoritySet)) {
            log.error("{}", R.failed(ApiErrorCode.PRIVILEGE_NOT_FOUND));
            return R.failed(ApiErrorCode.PRIVILEGE_NOT_FOUND);
        }
        userRolePrivilegeVo.setAuthoritySet(authoritySet);
        return R.ok(userRolePrivilegeVo);
    }

    @GetMapping("/authorities")
    public R<Map> getAuthority() {
        HashMap<String, Object> map = new HashMap<>(3);
        try {
            map.put("status", "ok");
            map.put("type", "");
            map.put("currentAuthority", SecurityContextUtil.getAuthorities());
        } catch (Exception e) {
            map.put("status", "error");
            log.error("", e.getMessage());
        }
        return R.ok(map);
    }

    @PostMapping("/getAllRoles")
    public R<List<RoleCheckbox>> getAllRoles(@RequestBody User user) {
        List<RoleCheckbox> roles = roleService.getAllRoles();
        List<RoleCheckbox> selectRoles = roleService.getSelectRoles(user);
        List<RoleCheckbox> roleCheckboxes = roles.stream().map(roleCheckbox -> {
            boolean anyMatch = selectRoles.stream().anyMatch(roleCheckbox1 -> roleCheckbox1.getValue().compareTo(roleCheckbox.getValue()) == 0);
            if (anyMatch) {
                roleCheckbox.setChecked(true);
            }
            return roleCheckbox;
        }).collect(Collectors.toList());
        return R.ok(roleCheckboxes);
    }

    @PostMapping("/addUserRole")
    public R addUserRole(@Valid @RequestBody UserRole userRole) {
        return R.ok(userRoleService.save(userRole));
    }

    @PostMapping("/deleteUserRole")
    public R deleteUserRole(@Valid @RequestBody UserRole userRole) {
        return R.ok(userRoleService.remove(Wrappers.query(userRole)));
    }

    @GetMapping("/currentUser")
    public R currentUser(){
        return userService.currentUser();
    }
}

