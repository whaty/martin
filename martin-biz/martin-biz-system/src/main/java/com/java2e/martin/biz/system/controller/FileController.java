package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.common.bean.system.File;
import com.java2e.martin.biz.system.service.FileService;
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
@RequestMapping("file")
@Api(value = "File 控制器", tags = "系统操作")
public class FileController {

    @Autowired
    private FileService fileService;


    /**
     * 添加
     *
     * @param file File
     * @return R
     */
    @MartinLog("添加系统操作")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_file_add')")
    public R save(@Valid @RequestBody File file) {
        return R.ok(fileService.save(file));
    }

    /**
     * 删除
     *
     * @param file File
     * @return R
     */
    @MartinLog("删除系统操作")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_file_del')")
    public R removeById(@Valid @RequestBody File file) {
        return R.ok(fileService.removeById(file.getId()));
    }

    /**
     * 编辑
     *
     * @param file File
     * @return R
     */
    @MartinLog("编辑系统操作")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys_file_edit')")
    public R update(@Valid @RequestBody File file) {
        file.setUpdateTime(LocalDateTime.now());
        return R.ok(fileService.updateById(file));
    }

    /**
     * 通过ID查询
     *
     * @param file File
     * @return R
     */
    @MartinLog("单个查询系统操作")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_file_get')")
    public R getById(@RequestBody File file) {
        return R.ok(fileService.getById(file.getId()));
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
        File file  = new File();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, file, true);
        } catch (Exception e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(fileService.page(page, Wrappers.query(file)));
    }


}

