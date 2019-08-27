package com.java2e.martin.biz.system.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.biz.system.entity.SysLog;
import com.java2e.martin.biz.system.service.SysLogService;
import com.java2e.martin.common.core.api.R;
import com.java2e.martin.common.core.enums.ApiErrorCode;
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
 * 日志表 前端控制器
 * </p>
 *
 * @author liangcan
 * @since 2019-08-23
 */
@Slf4j
@RestController
@RequestMapping("/sys-log")
@Api(value = "SysLog 控制器", tags = "日志表")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;


    /**
     * 添加
     *
     * @param sysLog SysLog
     * @return R
     */
    @MartinLog("添加日志表")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_log_add')")
    public R save(@Valid @RequestBody SysLog sysLog) {
        return R.ok(sysLogService.save(sysLog));
    }

    /**
     * 删除
     *
     * @param sysLog SysLog
     * @return R
     */
    @MartinLog("删除日志表")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_log_del')")
    public R removeById(@Valid @RequestBody SysLog sysLog) {
        return R.ok(sysLogService.removeById(sysLog.getId()));
    }

    /**
     * 编辑
     *
     * @param sysLog SysLog
     * @return R
     */
    @MartinLog("编辑日志表")
    @PostMapping
    @PreAuthorize("hasAuthority('sys_log_edit')")
    public R update(@Valid @RequestBody SysLog sysLog) {
        sysLog.setUpdateTime(LocalDateTime.now());
        return R.ok(sysLogService.updateById(sysLog));
    }

    /**
     * 通过ID查询
     *
     * @param sysLog SysLog
     * @return R
     */
    @MartinLog("单个查询日志表")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_log_get')")
    public R getById(@RequestBody SysLog sysLog) {
        return R.ok(sysLogService.getById(sysLog.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询日志表")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_log_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        Page page = new Page();
        SysLog sysLog = new SysLog();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, sysLog, true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(sysLogService.page(page, Wrappers.query(sysLog)));
    }


}

