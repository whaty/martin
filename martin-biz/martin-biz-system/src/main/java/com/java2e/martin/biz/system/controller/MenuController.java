package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.common.bean.system.Menu;
import com.java2e.martin.biz.system.service.MenuService;
import com.java2e.martin.common.bean.system.dto.MenuTreeNode;
import com.java2e.martin.common.bean.util.TreeUtil;
import com.java2e.martin.common.core.api.ApiErrorCode;
import com.java2e.martin.common.core.api.R;
import com.java2e.martin.common.core.constant.CommonConstants;
import com.java2e.martin.common.log.annotation.MartinLog;
import com.java2e.martin.common.security.util.SecurityContextUtil;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * <p>
 * 系统菜单 前端控制器
 * </p>
 *
 * @author liangcan
 * @since 2019-10-18
 */
@Slf4j
@RestController
@RequestMapping("menu")
@Api(value = "Menu 控制器", tags = "系统菜单")
public class MenuController {
    @Autowired
    private MenuService menuService;


    /**
     * 添加
     *
     * @param menu Menu
     * @return R
     */
    @MartinLog("添加系统菜单")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_menu_add')")
    public R save(@Valid @RequestBody Menu menu) {
        return R.ok(menuService.save(menu));
    }

    /**
     * 删除
     *
     * @param menu Menu
     * @return R
     */
    @MartinLog("删除系统菜单")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_menu_delete')")
    public R removeById(@Valid @RequestBody Menu menu) {
        return R.ok(menuService.removeById(menu.getId()));
    }

    /**
     * 编辑
     *
     * @param menu Menu
     * @return R
     */
    @MartinLog("编辑系统菜单")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys_menu_edit')")
    public R update(@Valid @RequestBody Menu menu) {
        menu.setUpdateTime(LocalDateTime.now());
        return R.ok(menuService.updateById(menu));
    }

    /**
     * 通过ID查询
     *
     * @param menu Menu
     * @return R
     */
    @MartinLog("单个查询系统菜单")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_menu_get')")
    public R getById(@RequestBody Menu menu) {
        Menu byId = menuService.getById(menu.getId());
        return R.ok(byId);
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统菜单")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_menu_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        Page page = new Page();
        Menu menu = new Menu();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, menu, true);
        } catch (Exception e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(menuService.page(page, Wrappers.query(menu)));
    }

    @MartinLog("获取所有系统菜单")
    @GetMapping("/tree")
    @PreAuthorize("hasAuthority('sys_menu_tree')")
    public R getMenuTree() {
        List<MenuTreeNode> routes = TreeUtil.buildRoutesByRecursive(menuService.list(Wrappers.<Menu>query().lambda().orderByAsc(Menu::getParentId, Menu::getSort)), CommonConstants.MENU_ROOT);
        Set<String> authorities = SecurityContextUtil.getAuthorities();
        SecurityContextUtil.getUser();
        HashMap<Object, Object> data = new HashMap<>(2);
        data.put("routes", routes);
        data.put("authorities", authorities);
        return R.ok(data);
    }

    @MartinLog("批量删除系统菜单")
    @PostMapping("/deleteBatch")
    @PreAuthorize("hasAuthority('sys_menu_deleteBatch')")
    public R removeBatch(@RequestBody String ids){
        List<String> idList = Arrays.stream(ids.split(",")).collect(Collectors.toList());
        if(CollUtil.isEmpty(idList)){
            return R.failed("id 不能为空");
        }
        return R.ok(menuService.removeByIds(idList));
    }


}

