package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.common.bean.system.RolePrivilege;
import com.java2e.martin.biz.system.service.RolePrivilegeService;
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
 * @author 狮少
 * @date 2019-10-18
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("role-privilege")
@Api(value = "RolePrivilege 控制器", tags = "系统角色权限关系")
public class RolePrivilegeController {

    @Autowired
    private RolePrivilegeService rolePrivilegeService;


    /**
     * 添加
     *
     * @param rolePrivilege RolePrivilege
     * @return R
     */
    @MartinLog("添加系统角色权限关系")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_role_privilege_add')")
    public R save(@Valid @RequestBody RolePrivilege rolePrivilege) {
        return R.ok(rolePrivilegeService.save(rolePrivilege));
    }

    /**
     * 删除
     *
     * @param rolePrivilege RolePrivilege
     * @return R
     */
    @MartinLog("删除系统角色权限关系")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_role_privilege_del')")
    public R removeById(@Valid @RequestBody RolePrivilege rolePrivilege) {
        return R.ok(rolePrivilegeService.removeById(rolePrivilege.getId()));
    }

    /**
     * 编辑
     *
     * @param rolePrivilege RolePrivilege
     * @return R
     */
    @MartinLog("编辑系统角色权限关系")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys_role_privilege_edit')")
    public R update(@Valid @RequestBody RolePrivilege rolePrivilege) {
        return R.ok(rolePrivilegeService.updateById(rolePrivilege));
    }

    /**
     * 通过ID查询
     *
     * @param rolePrivilege RolePrivilege
     * @return R
     */
    @MartinLog("单个查询系统角色权限关系")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_role_privilege_get')")
    public R getById(@RequestBody RolePrivilege rolePrivilege) {
        return R.ok(rolePrivilegeService.getById(rolePrivilege.getId()));
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
        RolePrivilege rolePrivilege  = new RolePrivilege();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, rolePrivilege, true);
        } catch (Exception e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(rolePrivilegeService.page(page, Wrappers.query(rolePrivilege)));
    }


}

