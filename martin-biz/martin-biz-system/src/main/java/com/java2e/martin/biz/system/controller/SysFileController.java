package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.common.bean.system.SysFile;
import com.java2e.martin.biz.system.service.SysFileService;
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
@RequestMapping("/sys-file")
@Api(value = "SysFile 控制器", tags = "系统操作")
public class SysFileController {

    @Autowired
    private SysFileService sysFileService;


    /**
     * 添加
     *
     * @param sysFile SysFile
     * @return R
     */
    @MartinLog("添加系统操作")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_file_add')")
    public R save(@Valid @RequestBody SysFile sysFile) {
        return R.ok(sysFileService.save(sysFile));
    }

    /**
     * 删除
     *
     * @param sysFile SysFile
     * @return R
     */
    @MartinLog("删除系统操作")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_file_del')")
    public R removeById(@Valid @RequestBody SysFile sysFile) {
        return R.ok(sysFileService.removeById(sysFile.getId()));
    }

    /**
     * 编辑
     *
     * @param sysFile SysFile
     * @return R
     */
    @MartinLog("编辑系统操作")
    @PostMapping
    @PreAuthorize("hasAuthority('sys_file_edit')")
    public R update(@Valid @RequestBody SysFile sysFile) {
        sysFile.setUpdateTime(LocalDateTime.now());
        return R.ok(sysFileService.updateById(sysFile));
    }

    /**
     * 通过ID查询
     *
     * @param sysFile SysFile
     * @return R
     */
    @MartinLog("单个查询系统操作")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_file_get')")
    public R getById(@RequestBody SysFile sysFile) {
        return R.ok(sysFileService.getById(sysFile.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统操作")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_file_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        Page page = new Page();
        SysFile sysFile = new SysFile();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, sysFile, true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(sysFileService.page(page, Wrappers.query(sysFile)));
    }


}

