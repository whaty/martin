package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.common.bean.system.SysUserRole;
import com.java2e.martin.biz.system.service.SysUserRoleService;
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
 * 系统用户角色关系 前端控制器
 * </p>
 *
 * @author liangcan
 * @since 2019-09-19
 */
@Slf4j
@RestController
@RequestMapping("/sys-user-role")
@Api(value = "SysUserRole 控制器", tags = "系统用户角色关系")
public class SysUserRoleController {

    @Autowired
    private SysUserRoleService sysUserRoleService;


    /**
     * 添加
     *
     * @param sysUserRole SysUserRole
     * @return R
     */
    @MartinLog("添加系统用户角色关系")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_user_role_add')")
    public R save(@Valid @RequestBody SysUserRole sysUserRole) {
        return R.ok(sysUserRoleService.save(sysUserRole));
    }

    /**
     * 删除
     *
     * @param sysUserRole SysUserRole
     * @return R
     */
    @MartinLog("删除系统用户角色关系")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_user_role_del')")
    public R removeById(@Valid @RequestBody SysUserRole sysUserRole) {
        return R.ok(sysUserRoleService.removeById(sysUserRole.getId()));
    }

    /**
     * 编辑
     *
     * @param sysUserRole SysUserRole
     * @return R
     */
    @MartinLog("编辑系统用户角色关系")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys_user_role_edit')")
    public R update(@Valid @RequestBody SysUserRole sysUserRole) {
        sysUserRole.setUpdateTime(LocalDateTime.now());
        return R.ok(sysUserRoleService.updateById(sysUserRole));
    }

    /**
     * 通过ID查询
     *
     * @param sysUserRole SysUserRole
     * @return R
     */
    @MartinLog("单个查询系统用户角色关系")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_user_role_get')")
    public R getById(@RequestBody SysUserRole sysUserRole) {
        return R.ok(sysUserRoleService.getById(sysUserRole.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统用户角色关系")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_user_role_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        Page page = new Page();
        SysUserRole sysUserRole = new SysUserRole();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, sysUserRole, true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(sysUserRoleService.page(page, Wrappers.query(sysUserRole)));
    }


}

