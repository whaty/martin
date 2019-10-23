package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.biz.system.service.PrivilegeService;
import com.java2e.martin.biz.system.service.UserRoleService;
import com.java2e.martin.biz.system.service.UserService;
import com.java2e.martin.common.bean.system.User;
import com.java2e.martin.common.bean.system.UserRole;
import com.java2e.martin.common.bean.system.dto.UserRolePrivilegeDto;
import com.java2e.martin.common.core.api.ApiErrorCode;
import com.java2e.martin.common.core.api.R;
import com.java2e.martin.common.log.annotation.MartinLog;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author liangcan
 * @since 2019-10-18
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
        user.setUpdateTime(LocalDateTime.now());
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
        Page page = new Page();
        User user = new User();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, user, true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(userService.page(page, Wrappers.query(user)));
    }

    @GetMapping("/loadUserByUsername/{username}")
    public R<UserRolePrivilegeDto> loadUserByUsername(@PathVariable String username) {
        UserRolePrivilegeDto userRolePrivilegeDto = new UserRolePrivilegeDto();
        User user = userService.getOne(Wrappers.<User>query().lambda().eq(User::getUsername, username));
        log.debug("{}", Convert.toStr(user));
        if (null == user) {
            return R.failed(ApiErrorCode.USERNOTFIND);
        }
        userRolePrivilegeDto.setUser(user);
        List<UserRole> roleList = userRoleService.list(Wrappers.<UserRole>query().lambda().eq(UserRole::getUserId, user.getId()));
        if (CollectionUtil.isEmpty(roleList)) {
            log.error("{}", R.failed(ApiErrorCode.ROLENOTFIND));
            return R.failed(ApiErrorCode.ROLENOTFIND);
        }
        Set<String> authoritySet = privilegeService.getPrivilegeByRoles(roleList);
        if (CollectionUtil.isEmpty(authoritySet)) {
            log.error("{}", R.failed(ApiErrorCode.PRIVILEGENOTFIND));
            return R.failed(ApiErrorCode.PRIVILEGENOTFIND);
        }
        userRolePrivilegeDto.setAuthoritySet(authoritySet);
        return R.ok(userRolePrivilegeDto);
    }

}

