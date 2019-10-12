package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.biz.system.service.SysMenuService;
import com.java2e.martin.common.bean.system.SysMenu;
import com.java2e.martin.common.bean.system.SysUser;
import com.java2e.martin.common.bean.util.TreeUtil;
import com.java2e.martin.common.core.api.ApiErrorCode;
import com.java2e.martin.common.core.api.R;
import com.java2e.martin.common.core.constant.CommonConstants;
import com.java2e.martin.common.log.annotation.MartinLog;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * <p>
 * 系统菜单 前端控制器
 * </p>
 *
 * @author liangcan
 * @since 2019-09-19
 */
@Slf4j
@RestController
@RequestMapping("/sys-menu")
@Api(value = "SysMenu 控制器", tags = "系统菜单")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;


    /**
     * 添加
     *
     * @param sysMenu SysMenu
     * @return R
     */
    @MartinLog("添加系统菜单")
    @PostMapping("/add")
    public R save(@Valid @RequestBody SysMenu sysMenu) {
        return R.ok(sysMenuService.save(sysMenu));
    }

    /**
     * 删除
     *
     * @param sysMenu SysMenu
     * @return R
     */
    @MartinLog("删除系统菜单")
    @PostMapping("/delete")
    public R removeById(@Valid @RequestBody SysMenu sysMenu) {
        return R.ok(sysMenuService.removeById(sysMenu.getId()));
    }

    /**
     * 编辑
     *
     * @param sysMenu SysMenu
     * @return R
     */
//    @MartinLog("编辑系统菜单")
    @PostMapping("/update")
//    @PreAuthorize("hasAuthority('sys_menu_edit')")
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
//    @MartinLog("单个查询系统菜单")
    @PostMapping("/get")
//    @PreAuthorize("hasAuthority('sys_menu_get')")

    public R getById(@RequestBody SysMenu sysMenu) {
        SysMenu byId = sysMenuService.getById(sysMenu.getId());
        return R.ok(byId);
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @PostMapping("/page")
    public R<IPage> getPage(@RequestBody Map params) {
        Page page = new Page();
        SysMenu sysMenu = new SysMenu();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, sysMenu, true);
        } catch (Exception e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(sysMenuService.page(page, Wrappers.query(sysMenu)));
    }

    @GetMapping("/tree")
    public R getMenuTree() {
        return R.ok(TreeUtil.buildByRecursive(sysMenuService.list(Wrappers.<SysMenu>query().lambda().orderByAsc(SysMenu::getParentId,SysMenu::getSort)), CommonConstants.MENU_ROOT));
    }

    @MartinLog("批量删除系统菜单")
    @PostMapping("/deleteBatch")
    public R removeBatch(@RequestBody String ids){
        List<String> idList = Arrays.stream(ids.split(",")).collect(Collectors.toList());
        if(CollUtil.isEmpty(idList)){
            return R.failed("id 不能为空");
        }
        return R.ok(sysMenuService.removeByIds(idList));
    }

}

