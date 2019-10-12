package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.biz.system.service.SysPrivilegeService;
import com.java2e.martin.biz.system.service.SysRolePrivilegeService;
import com.java2e.martin.biz.system.service.SysUserRoleService;
import com.java2e.martin.biz.system.service.SysUserService;
import com.java2e.martin.common.bean.system.SysUser;
import com.java2e.martin.common.bean.system.SysUserRole;
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
 * @since 2019-09-11
 */
@Slf4j
@RestController
@RequestMapping("/sys-user")
@Api(value = "SysUser 控制器", tags = "系统用户")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysPrivilegeService sysPrivilegeService;



    /**
     * 添加
     *
     * @param sysUser SysUser
     * @return R
     */
    @MartinLog("添加系统用户")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_user_add')")
    public R save(@Valid @RequestBody SysUser sysUser) {
        return R.ok(sysUserService.save(sysUser));
    }

    /**
     * 删除
     *
     * @param sysUser SysUser
     * @return R
     */
    @MartinLog("删除系统用户")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_user_del')")
    public R removeById(@Valid @RequestBody SysUser sysUser) {
        return R.ok(sysUserService.removeById(sysUser.getId()));
    }

    /**
     * 编辑
     *
     * @param sysUser SysUser
     * @return R
     */
    @MartinLog("编辑系统用户")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys_user_edit')")
    public R update(@Valid @RequestBody SysUser sysUser) {
        sysUser.setUpdateTime(LocalDateTime.now());
        return R.ok(sysUserService.updateById(sysUser));
    }

    /**
     * 通过ID查询
     *
     * @param sysUser SysUser
     * @return R
     */
    @MartinLog("单个查询系统用户")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_user_get')")
    public R getById(@RequestBody SysUser sysUser) {
        return R.ok(sysUserService.getById(sysUser.getId()));
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
        SysUser sysUser = new SysUser();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, sysUser, true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(sysUserService.page(page, Wrappers.query(sysUser)));
    }

    @GetMapping("/loadUserByUsername/{username}")
    public R<UserRolePrivilegeDto> loadUserByUsername(@PathVariable String username) {
        UserRolePrivilegeDto userRolePrivilegeDto = new UserRolePrivilegeDto();
        SysUser sysUser = sysUserService.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUsername, username));
        log.debug("{}", Convert.toStr(sysUser));
        if (null == sysUser) {
            return R.failed(ApiErrorCode.USERNOTFIND);
        }
        userRolePrivilegeDto.setSysUser(sysUser);
        List<SysUserRole> roleList = sysUserRoleService.list(Wrappers.<SysUserRole>query().lambda().eq(SysUserRole::getUserId, sysUser.getId()));
        if (CollectionUtil.isEmpty(roleList)) {
            log.error("{}",R.failed(ApiErrorCode.ROLENOTFIND));
            return R.failed(ApiErrorCode.ROLENOTFIND);
        }
        Set<String> authoritySet = sysPrivilegeService.getPrivilegeByRoles(roleList);
        if (CollectionUtil.isEmpty(authoritySet)) {
            log.error("{}",R.failed(ApiErrorCode.PRIVILEGENOTFIND));
            return R.failed(ApiErrorCode.PRIVILEGENOTFIND);
        }
        userRolePrivilegeDto.setAuthoritySet(authoritySet);
        return R.ok(userRolePrivilegeDto);
    }

}

