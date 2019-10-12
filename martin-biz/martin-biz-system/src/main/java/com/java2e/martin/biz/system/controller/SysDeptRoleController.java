package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.common.bean.system.SysDeptRole;
import com.java2e.martin.biz.system.service.SysDeptRoleService;
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
 * 系统部门角色关系 前端控制器
 * </p>
 *
 * @author liangcan
 * @since 2019-09-19
 */
@Slf4j
@RestController
@RequestMapping("/sys-dept-role")
@Api(value = "SysDeptRole 控制器", tags = "系统部门角色关系")
public class SysDeptRoleController {

    @Autowired
    private SysDeptRoleService sysDeptRoleService;


    /**
     * 添加
     *
     * @param sysDeptRole SysDeptRole
     * @return R
     */
    @MartinLog("添加系统部门角色关系")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_dept_role_add')")
    public R save(@Valid @RequestBody SysDeptRole sysDeptRole) {
        return R.ok(sysDeptRoleService.save(sysDeptRole));
    }

    /**
     * 删除
     *
     * @param sysDeptRole SysDeptRole
     * @return R
     */
    @MartinLog("删除系统部门角色关系")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_dept_role_del')")
    public R removeById(@Valid @RequestBody SysDeptRole sysDeptRole) {
        return R.ok(sysDeptRoleService.removeById(sysDeptRole.getId()));
    }

    /**
     * 编辑
     *
     * @param sysDeptRole SysDeptRole
     * @return R
     */
    @MartinLog("编辑系统部门角色关系")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys_dept_role_edit')")
    public R update(@Valid @RequestBody SysDeptRole sysDeptRole) {
        sysDeptRole.setUpdateTime(LocalDateTime.now());
        return R.ok(sysDeptRoleService.updateById(sysDeptRole));
    }

    /**
     * 通过ID查询
     *
     * @param sysDeptRole SysDeptRole
     * @return R
     */
    @MartinLog("单个查询系统部门角色关系")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_dept_role_get')")
    public R getById(@RequestBody SysDeptRole sysDeptRole) {
        return R.ok(sysDeptRoleService.getById(sysDeptRole.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统部门角色关系")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_dept_role_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        Page page = new Page();
        SysDeptRole sysDeptRole = new SysDeptRole();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, sysDeptRole, true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(sysDeptRoleService.page(page, Wrappers.query(sysDeptRole)));
    }


}

