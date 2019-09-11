package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.common.bean.system.SysDict;
import com.java2e.martin.biz.system.service.SysDictService;
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
 * 系统字典 前端控制器
 * </p>
 *
 * @author liangcan
 * @since 2019-09-11
 */
@Slf4j
@RestController
@RequestMapping("/sys-dict")
@Api(value = "SysDict 控制器", tags = "系统字典")
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;


    /**
     * 添加
     *
     * @param sysDict SysDict
     * @return R
     */
    @MartinLog("添加系统字典")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_dict_add')")
    public R save(@Valid @RequestBody SysDict sysDict) {
        return R.ok(sysDictService.save(sysDict));
    }

    /**
     * 删除
     *
     * @param sysDict SysDict
     * @return R
     */
    @MartinLog("删除系统字典")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_dict_del')")
    public R removeById(@Valid @RequestBody SysDict sysDict) {
        return R.ok(sysDictService.removeById(sysDict.getId()));
    }

    /**
     * 编辑
     *
     * @param sysDict SysDict
     * @return R
     */
    @MartinLog("编辑系统字典")
    @PostMapping
    @PreAuthorize("hasAuthority('sys_dict_edit')")
    public R update(@Valid @RequestBody SysDict sysDict) {
        sysDict.setUpdateTime(LocalDateTime.now());
        return R.ok(sysDictService.updateById(sysDict));
    }

    /**
     * 通过ID查询
     *
     * @param sysDict SysDict
     * @return R
     */
    @MartinLog("单个查询系统字典")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_dict_get')")
    public R getById(@RequestBody SysDict sysDict) {
        return R.ok(sysDictService.getById(sysDict.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统字典")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_dict_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        Page page = new Page();
        SysDict sysDict = new SysDict();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, sysDict, true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(sysDictService.page(page, Wrappers.query(sysDict)));
    }


}

