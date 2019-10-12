package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.common.bean.system.SysDeptUser;
import com.java2e.martin.biz.system.service.SysDeptUserService;
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
 * 系统用户部门关系 前端控制器
 * </p>
 *
 * @author liangcan
 * @since 2019-09-19
 */
@Slf4j
@RestController
@RequestMapping("/sys-dept-user")
@Api(value = "SysDeptUser 控制器", tags = "系统用户部门关系")
public class SysDeptUserController {

    @Autowired
    private SysDeptUserService sysDeptUserService;


    /**
     * 添加
     *
     * @param sysDeptUser SysDeptUser
     * @return R
     */
    @MartinLog("添加系统用户部门关系")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_dept_user_add')")
    public R save(@Valid @RequestBody SysDeptUser sysDeptUser) {
        return R.ok(sysDeptUserService.save(sysDeptUser));
    }

    /**
     * 删除
     *
     * @param sysDeptUser SysDeptUser
     * @return R
     */
    @MartinLog("删除系统用户部门关系")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_dept_user_del')")
    public R removeById(@Valid @RequestBody SysDeptUser sysDeptUser) {
        return R.ok(sysDeptUserService.removeById(sysDeptUser.getId()));
    }

    /**
     * 编辑
     *
     * @param sysDeptUser SysDeptUser
     * @return R
     */
    @MartinLog("编辑系统用户部门关系")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys_dept_user_edit')")
    public R update(@Valid @RequestBody SysDeptUser sysDeptUser) {
        sysDeptUser.setUpdateTime(LocalDateTime.now());
        return R.ok(sysDeptUserService.updateById(sysDeptUser));
    }

    /**
     * 通过ID查询
     *
     * @param sysDeptUser SysDeptUser
     * @return R
     */
    @MartinLog("单个查询系统用户部门关系")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_dept_user_get')")
    public R getById(@RequestBody SysDeptUser sysDeptUser) {
        return R.ok(sysDeptUserService.getById(sysDeptUser.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统用户部门关系")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_dept_user_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        Page page = new Page();
        SysDeptUser sysDeptUser = new SysDeptUser();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, sysDeptUser, true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(sysDeptUserService.page(page, Wrappers.query(sysDeptUser)));
    }


}

