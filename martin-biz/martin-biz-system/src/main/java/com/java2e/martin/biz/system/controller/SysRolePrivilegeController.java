package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.common.bean.system.SysRolePrivilege;
import com.java2e.martin.biz.system.service.SysRolePrivilegeService;
import com.java2e.martin.common.core.api.ApiErrorCode;
import com.java2e.martin.common.core.api.R;
import com.java2e.martin.common.log.annotation.MartinLog;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;



/**
 * <p>
 * 系统角色权限关系 前端控制器
 * </p>
 *
 * @author liangcan
 * @since 2019-09-11
 */
@Slf4j
@RestController
@RequestMapping("/sys-role-privilege")
@Api(value = "SysRolePrivilege 控制器", tags = "系统角色权限关系")
public class SysRolePrivilegeController {

    @Autowired
    private SysRolePrivilegeService sysRolePrivilegeService;


    /**
     * 添加
     *
     * @param sysRolePrivilege SysRolePrivilege
     * @return R
     */
    @MartinLog("添加系统角色权限关系")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_role_privilege_add')")
    public R save(@Valid @RequestBody SysRolePrivilege sysRolePrivilege) {
        return R.ok(sysRolePrivilegeService.save(sysRolePrivilege));
    }

    /**
     * 删除
     *
     * @param sysRolePrivilege SysRolePrivilege
     * @return R
     */
    @MartinLog("删除系统角色权限关系")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_role_privilege_del')")
    public R removeById(@Valid @RequestBody SysRolePrivilege sysRolePrivilege) {
        return R.ok(sysRolePrivilegeService.removeById(sysRolePrivilege.getId()));
    }

    /**
     * 编辑
     *
     * @param sysRolePrivilege SysRolePrivilege
     * @return R
     */
    @MartinLog("编辑系统角色权限关系")
    @PostMapping
    @PreAuthorize("hasAuthority('sys_role_privilege_edit')")
    public R update(@Valid @RequestBody SysRolePrivilege sysRolePrivilege) {
        sysRolePrivilege.setUpdateTime(LocalDateTime.now());
        return R.ok(sysRolePrivilegeService.updateById(sysRolePrivilege));
    }

    /**
     * 通过ID查询
     *
     * @param sysRolePrivilege SysRolePrivilege
     * @return R
     */
    @MartinLog("单个查询系统角色权限关系")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_role_privilege_get')")
    public R getById(@RequestBody SysRolePrivilege sysRolePrivilege) {
        return R.ok(sysRolePrivilegeService.getById(sysRolePrivilege.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统角色权限关系")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_role_privilege_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        Page page = new Page();
        SysRolePrivilege sysRolePrivilege = new SysRolePrivilege();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, sysRolePrivilege, true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(sysRolePrivilegeService.page(page, Wrappers.query(sysRolePrivilege)));
    }


}

