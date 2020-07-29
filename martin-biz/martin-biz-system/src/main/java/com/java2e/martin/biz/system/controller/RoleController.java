package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.common.bean.system.Role;
import com.java2e.martin.biz.system.service.RoleService;
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
 * @author 狮少
 * @date 2019-10-18
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("role")
@Api(value = "Role 控制器", tags = "系统角色")
public class RoleController {

    @Autowired
    private RoleService roleService;


    /**
     * 添加
     *
     * @param role Role
     * @return R
     */
    @MartinLog("添加系统角色")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_role_add')")
    public R save(@Valid @RequestBody Role role) {
        return R.ok(roleService.save(role));
    }

    /**
     * 删除
     *
     * @param role Role
     * @return R
     */
    @MartinLog("删除系统角色")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_role_del')")
    public R removeById(@Valid @RequestBody Role role) {
        return R.ok(roleService.removeById(role.getId()));
    }

    /**
     * 编辑
     *
     * @param role Role
     * @return R
     */
    @MartinLog("编辑系统角色")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys_role_edit')")
    public R update(@Valid @RequestBody Role role) {
        role.setUpdateTime(LocalDateTime.now());
        return R.ok(roleService.updateById(role));
    }

    /**
     * 通过ID查询
     *
     * @param role Role
     * @return R
     */
    @MartinLog("单个查询系统角色")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_role_get')")
    public R getById(@RequestBody Role role) {
        return R.ok(roleService.getById(role.getId()));
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
        Role role  = new Role();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, role, true);
        } catch (Exception e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(roleService.page(page, Wrappers.query(role)));
    }


}

