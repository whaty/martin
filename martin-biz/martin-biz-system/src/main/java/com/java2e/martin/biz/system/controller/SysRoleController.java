package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.common.bean.system.SysRole;
import com.java2e.martin.biz.system.service.SysRoleService;
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
 * 系统角色 前端控制器
 * </p>
 *
 * @author liangcan
 * @since 2019-09-11
 */
@Slf4j
@RestController
@RequestMapping("/sys-role")
@Api(value = "SysRole 控制器", tags = "系统角色")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;


    /**
     * 添加
     *
     * @param sysRole SysRole
     * @return R
     */
    @MartinLog("添加系统角色")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_role_add')")
    public R save(@Valid @RequestBody SysRole sysRole) {
        return R.ok(sysRoleService.save(sysRole));
    }

    /**
     * 删除
     *
     * @param sysRole SysRole
     * @return R
     */
    @MartinLog("删除系统角色")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_role_del')")
    public R removeById(@Valid @RequestBody SysRole sysRole) {
        return R.ok(sysRoleService.removeById(sysRole.getId()));
    }

    /**
     * 编辑
     *
     * @param sysRole SysRole
     * @return R
     */
    @MartinLog("编辑系统角色")
    @PostMapping
    @PreAuthorize("hasAuthority('sys_role_edit')")
    public R update(@Valid @RequestBody SysRole sysRole) {
        sysRole.setUpdateTime(LocalDateTime.now());
        return R.ok(sysRoleService.updateById(sysRole));
    }

    /**
     * 通过ID查询
     *
     * @param sysRole SysRole
     * @return R
     */
    @MartinLog("单个查询系统角色")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_role_get')")
    public R getById(@RequestBody SysRole sysRole) {
        return R.ok(sysRoleService.getById(sysRole.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统角色")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_role_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        Page page = new Page();
        SysRole sysRole = new SysRole();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, sysRole, true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(sysRoleService.page(page, Wrappers.query(sysRole)));
    }


}

