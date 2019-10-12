package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.common.bean.system.SysDept;
import com.java2e.martin.biz.system.service.SysDeptService;
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
 * 系统部门 前端控制器
 * </p>
 *
 * @author liangcan
 * @since 2019-09-19
 */
@Slf4j
@RestController
@RequestMapping("/sys-dept")
@Api(value = "SysDept 控制器", tags = "系统部门")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;


    /**
     * 添加
     *
     * @param sysDept SysDept
     * @return R
     */
    @MartinLog("添加系统部门")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_dept_add')")
    public R save(@Valid @RequestBody SysDept sysDept) {
        return R.ok(sysDeptService.save(sysDept));
    }

    /**
     * 删除
     *
     * @param sysDept SysDept
     * @return R
     */
    @MartinLog("删除系统部门")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_dept_del')")
    public R removeById(@Valid @RequestBody SysDept sysDept) {
        return R.ok(sysDeptService.removeById(sysDept.getId()));
    }

    /**
     * 编辑
     *
     * @param sysDept SysDept
     * @return R
     */
    @MartinLog("编辑系统部门")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys_dept_edit')")
    public R update(@Valid @RequestBody SysDept sysDept) {
        sysDept.setUpdateTime(LocalDateTime.now());
        return R.ok(sysDeptService.updateById(sysDept));
    }

    /**
     * 通过ID查询
     *
     * @param sysDept SysDept
     * @return R
     */
    @MartinLog("单个查询系统部门")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_dept_get')")
    public R getById(@RequestBody SysDept sysDept) {
        return R.ok(sysDeptService.getById(sysDept.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统部门")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_dept_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        Page page = new Page();
        SysDept sysDept = new SysDept();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, sysDept, true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(sysDeptService.page(page, Wrappers.query(sysDept)));
    }


}

