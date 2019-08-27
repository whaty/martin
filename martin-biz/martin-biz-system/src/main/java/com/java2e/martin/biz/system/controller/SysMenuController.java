package com.java2e.martin.biz.system.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.biz.system.entity.SysMenu;
import com.java2e.martin.biz.system.service.SysMenuService;
import com.java2e.martin.common.core.api.R;
import com.java2e.martin.common.core.enums.ApiErrorCode;
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
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author liangcan
 * @since 2019-08-23
 */
@Slf4j
@RestController
@RequestMapping("/sys-menu")
@Api(value = "SysMenu 控制器", tags = "菜单权限表")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;


    /**
     * 添加
     *
     * @param sysMenu SysMenu
     * @return R
     */
    @MartinLog("添加菜单权限表")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_menu_add')")
    public R save(@Valid @RequestBody SysMenu sysMenu) {
        return R.ok(sysMenuService.save(sysMenu));
    }

    /**
     * 删除
     *
     * @param sysMenu SysMenu
     * @return R
     */
    @MartinLog("删除菜单权限表")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_menu_del')")
    public R removeById(@Valid @RequestBody SysMenu sysMenu) {
        return R.ok(sysMenuService.removeById(sysMenu.getId()));
    }

    /**
     * 编辑
     *
     * @param sysMenu SysMenu
     * @return R
     */
    @MartinLog("编辑菜单权限表")
    @PostMapping
    @PreAuthorize("hasAuthority('sys_menu_edit')")
    public R update(@Valid @RequestBody SysMenu sysMenu) {
        sysMenu.setUpdateTime(LocalDateTime.now());
        return R.ok(sysMenuService.updateById(sysMenu));
    }

    /**
     * 通过ID查询
     *
     * @param sysMenu SysMenu
     * @return R
     */
    @MartinLog("单个查询菜单权限表")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_menu_get')")
    public R getById(@RequestBody SysMenu sysMenu) {
        return R.ok(sysMenuService.getById(sysMenu.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询菜单权限表")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_menu_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        Page page = new Page();
        SysMenu sysMenu = new SysMenu();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, sysMenu, true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(sysMenuService.page(page, Wrappers.query(sysMenu)));
    }


}

