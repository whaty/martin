package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.common.bean.system.Operation;
import com.java2e.martin.biz.system.service.OperationService;
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
 * @author 狮少
 * @date 2019-10-18
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("operation")
@Api(value = "Operation 控制器", tags = "系统操作")
public class OperationController {

    @Autowired
    private OperationService operationService;


    /**
     * 添加
     *
     * @param operation Operation
     * @return R
     */
    @MartinLog("添加系统操作")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_operation_add')")
    public R save(@Valid @RequestBody Operation operation) {
        return R.ok(operationService.save(operation));
    }

    /**
     * 删除
     *
     * @param operation Operation
     * @return R
     */
    @MartinLog("删除系统操作")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_operation_del')")
    public R removeById(@Valid @RequestBody Operation operation) {
        return R.ok(operationService.removeById(operation.getId()));
    }

    /**
     * 编辑
     *
     * @param operation Operation
     * @return R
     */
    @MartinLog("编辑系统操作")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys_operation_edit')")
    public R update(@Valid @RequestBody Operation operation) {
        return R.ok(operationService.updateById(operation));
    }

    /**
     * 通过ID查询
     *
     * @param operation Operation
     * @return R
     */
    @MartinLog("单个查询系统操作")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_operation_get')")
    public R getById(@RequestBody Operation operation) {
        return R.ok(operationService.getById(operation.getId()));
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
        try {
            return R.ok(operationService.getPage(params));
        } catch (IllegalAccessException e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        } catch (InstantiationException e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        }
    }


}

