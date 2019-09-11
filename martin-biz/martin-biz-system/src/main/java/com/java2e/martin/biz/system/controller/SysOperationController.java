package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.common.bean.system.SysOperation;
import com.java2e.martin.biz.system.service.SysOperationService;
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
 * 系统操作 前端控制器
 * </p>
 *
 * @author liangcan
 * @since 2019-09-11
 */
@Slf4j
@RestController
@RequestMapping("/sys-operation")
@Api(value = "SysOperation 控制器", tags = "系统操作")
public class SysOperationController {

    @Autowired
    private SysOperationService sysOperationService;


    /**
     * 添加
     *
     * @param sysOperation SysOperation
     * @return R
     */
    @MartinLog("添加系统操作")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_operation_add')")
    public R save(@Valid @RequestBody SysOperation sysOperation) {
        return R.ok(sysOperationService.save(sysOperation));
    }

    /**
     * 删除
     *
     * @param sysOperation SysOperation
     * @return R
     */
    @MartinLog("删除系统操作")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_operation_del')")
    public R removeById(@Valid @RequestBody SysOperation sysOperation) {
        return R.ok(sysOperationService.removeById(sysOperation.getId()));
    }

    /**
     * 编辑
     *
     * @param sysOperation SysOperation
     * @return R
     */
    @MartinLog("编辑系统操作")
    @PostMapping
    @PreAuthorize("hasAuthority('sys_operation_edit')")
    public R update(@Valid @RequestBody SysOperation sysOperation) {
        sysOperation.setUpdateTime(LocalDateTime.now());
        return R.ok(sysOperationService.updateById(sysOperation));
    }

    /**
     * 通过ID查询
     *
     * @param sysOperation SysOperation
     * @return R
     */
    @MartinLog("单个查询系统操作")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_operation_get')")
    public R getById(@RequestBody SysOperation sysOperation) {
        return R.ok(sysOperationService.getById(sysOperation.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统操作")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_operation_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        Page page = new Page();
        SysOperation sysOperation = new SysOperation();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, sysOperation, true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(sysOperationService.page(page, Wrappers.query(sysOperation)));
    }


}

