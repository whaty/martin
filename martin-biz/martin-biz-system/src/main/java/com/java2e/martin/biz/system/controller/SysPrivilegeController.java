package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.biz.system.entity.SysPrivilege;
import com.java2e.martin.biz.system.service.SysPrivilegeService;
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
 * 系统权限 前端控制器
 * </p>
 *
 * @author liangcan
 * @since 2019-09-05
 */
@Slf4j
@RestController
@RequestMapping("/sys-privilege")
@Api(value = "SysPrivilege 控制器", tags = "系统权限")
public class SysPrivilegeController {

    @Autowired
    private SysPrivilegeService sysPrivilegeService;


    /**
     * 添加
     *
     * @param sysPrivilege SysPrivilege
     * @return R
     */
    @MartinLog("添加系统权限")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_privilege_add')")
    public R save(@Valid @RequestBody SysPrivilege sysPrivilege) {
        return R.ok(sysPrivilegeService.save(sysPrivilege));
    }

    /**
     * 删除
     *
     * @param sysPrivilege SysPrivilege
     * @return R
     */
    @MartinLog("删除系统权限")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_privilege_del')")
    public R removeById(@Valid @RequestBody SysPrivilege sysPrivilege) {
        return R.ok(sysPrivilegeService.removeById(sysPrivilege.getId()));
    }

    /**
     * 编辑
     *
     * @param sysPrivilege SysPrivilege
     * @return R
     */
    @MartinLog("编辑系统权限")
    @PostMapping
    @PreAuthorize("hasAuthority('sys_privilege_edit')")
    public R update(@Valid @RequestBody SysPrivilege sysPrivilege) {
        sysPrivilege.setUpdateTime(LocalDateTime.now());
        return R.ok(sysPrivilegeService.updateById(sysPrivilege));
    }

    /**
     * 通过ID查询
     *
     * @param sysPrivilege SysPrivilege
     * @return R
     */
    @MartinLog("单个查询系统权限")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_privilege_get')")
    public R getById(@RequestBody SysPrivilege sysPrivilege) {
        return R.ok(sysPrivilegeService.getById(sysPrivilege.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统权限")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_privilege_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        Page page = new Page();
        SysPrivilege sysPrivilege = new SysPrivilege();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, sysPrivilege, true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(sysPrivilegeService.page(page, Wrappers.query(sysPrivilege)));
    }


}

