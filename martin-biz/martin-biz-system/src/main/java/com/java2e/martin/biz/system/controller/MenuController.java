package com.java2e.martin.biz.system.controller;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.java2e.martin.biz.system.service.MenuService;
import com.java2e.martin.biz.system.service.OperationService;
import com.java2e.martin.common.bean.system.Menu;
import com.java2e.martin.common.bean.system.dto.MenuTreeNode;
import com.java2e.martin.common.core.api.ApiErrorCode;
import com.java2e.martin.common.core.api.R;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * <p>
 * 系统菜单 前端控制器
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("menu")
@Api(value = "Menu 控制器", tags = "系统菜单")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private OperationService operationService;


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
    public R getPage(@RequestBody Map params) {
        try {
            IPage<Menu> page = menuService.getPage(params);
            List<MenuTreeNode> menuTree = menuService.getAllMenuTree();
            HashMap<String, Object> map = new HashMap<>(2);
            map.put("page", page);
            map.put("menuTree", menuTree);
            return R.ok(map);
        } catch (IllegalAccessException e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        } catch (InstantiationException e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        }
    }

    @MartinLog("获取当前用户拥有的菜单")
    @GetMapping("/getCurrentUserMenusByRoles")
    @PreAuthorize("hasAuthority('sys_menu_tree')")
    public R getCurrentUserMenusByRoles() {
        List<MenuTreeNode> list = menuService.getCurrentUserMenusByRoles();
        return R.ok(list);
    }

    @MartinLog("批量删除系统菜单")
    @PostMapping("/deleteBatch")
    @PreAuthorize("hasAuthority('sys_menu_deleteBatch')")
    public R removeBatch(@RequestBody String ids) {
        List<String> idList = Arrays.stream(ids.split(",")).collect(Collectors.toList());
        if (CollUtil.isEmpty(idList)) {
            return R.failed("id 不能为空");
        }
        return R.ok(menuService.removeByIds(idList));
    }

    @MartinLog("批量添加系统菜单")
    @PostMapping("/batchSave")
    public R removeBatch(@RequestBody List<Menu> list) {
        return R.ok(menuService.saveBatch(list));
    }

    @MartinLog("生成菜单CRUD按钮")
    @PostMapping("/generateOperation")
    public R generateOperation(@RequestBody Menu menu) {
        return operationService.generateOperation(menu);
    }


}

