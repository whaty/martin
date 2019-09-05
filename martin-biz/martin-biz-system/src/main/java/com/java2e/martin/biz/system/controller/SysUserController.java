package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.biz.system.entity.SysUser;
import com.java2e.martin.biz.system.service.SysUserService;
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
 * 系统用户 前端控制器
 * </p>
 *
 * @author liangcan
 * @since 2019-09-05
 */
@Slf4j
@RestController
@RequestMapping("/sys-user")
@Api(value = "SysUser 控制器", tags = "系统用户")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    /**
     * 添加
     *
     * @param sysUser SysUser
     * @return R
     */
    @MartinLog("添加系统用户")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_user_add')")
    public R save(@Valid @RequestBody SysUser sysUser) {
        return R.ok(sysUserService.save(sysUser));
    }

    /**
     * 删除
     *
     * @param sysUser SysUser
     * @return R
     */
    @MartinLog("删除系统用户")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_user_del')")
    public R removeById(@Valid @RequestBody SysUser sysUser) {
        return R.ok(sysUserService.removeById(sysUser.getId()));
    }

    /**
     * 编辑
     *
     * @param sysUser SysUser
     * @return R
     */
    @MartinLog("编辑系统用户")
    @PostMapping
    @PreAuthorize("hasAuthority('sys_user_edit')")
    public R update(@Valid @RequestBody SysUser sysUser) {
        sysUser.setUpdateTime(LocalDateTime.now());
        return R.ok(sysUserService.updateById(sysUser));
    }

    /**
     * 通过ID查询
     *
     * @param sysUser SysUser
     * @return R
     */
    @MartinLog("单个查询系统用户")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_user_get')")
    public R getById(@RequestBody SysUser sysUser) {
        return R.ok(sysUserService.getById(sysUser.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统用户")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_user_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        Page page = new Page();
        SysUser sysUser = new SysUser();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, sysUser, true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(sysUserService.page(page, Wrappers.query(sysUser)));
    }


}

