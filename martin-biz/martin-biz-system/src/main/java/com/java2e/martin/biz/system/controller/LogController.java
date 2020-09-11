package com.java2e.martin.biz.system.controller;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.java2e.martin.biz.system.service.LogService;
import com.java2e.martin.common.bean.system.Log;
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
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * <p>
 * 系统日志 前端控制器
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("log")
@Api(value = "Log 控制器", tags = "系统日志")
public class LogController {

    @Autowired
    private LogService logService;


    /**
     * 添加
     *
     * @param logger Log
     * @return R
     */
    @MartinLog("添加系统日志")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_log_add')")
    public R save(@Valid @RequestBody Log logger) {
        return R.ok(logService.save(logger));
    }

    /**
     * 删除
     *
     * @param logger Log
     * @return R
     */
    @MartinLog("删除系统日志")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_log_del')")
    public R removeById(@Valid @RequestBody Log logger) {
        return R.ok(logService.removeById(logger.getId()));
    }

    /**
     * 编辑
     *
     * @param logger Log
     * @return R
     */
    @MartinLog("编辑系统日志")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys_log_edit')")
    public R update(@Valid @RequestBody Log logger) {
        return R.ok(logService.updateById(logger));
    }

    /**
     * 通过ID查询
     *
     * @param logger Log
     * @return R
     */
    @MartinLog("单个查询系统日志")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_log_get')")
    public R getById(@RequestBody Log logger) {
        return R.ok(logService.getById(logger.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统日志")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_log_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        try {
            return R.ok(logService.getPage(params));
        } catch (IllegalAccessException e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        } catch (InstantiationException e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        }
    }

    @MartinLog("批量删除系统日志")
    @PostMapping("/deleteBatch")
    @PreAuthorize("hasAuthority('sys_log_deleteBatch')")
    public R removeBatch(@RequestBody String ids) {
        List<String> idList = Arrays.stream(ids.split(",")).collect(Collectors.toList());
        if (CollUtil.isEmpty(idList)) {
            return R.failed("id 不能为空");
        }
        return R.ok(logService.removeByIds(idList));
    }


}

