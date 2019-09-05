package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.biz.system.entity.SysElement;
import com.java2e.martin.biz.system.service.SysElementService;
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
 * 系统页面元素 前端控制器
 * </p>
 *
 * @author liangcan
 * @since 2019-09-05
 */
@Slf4j
@RestController
@RequestMapping("/sys-element")
@Api(value = "SysElement 控制器", tags = "系统页面元素")
public class SysElementController {

    @Autowired
    private SysElementService sysElementService;


    /**
     * 添加
     *
     * @param sysElement SysElement
     * @return R
     */
    @MartinLog("添加系统页面元素")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_element_add')")
    public R save(@Valid @RequestBody SysElement sysElement) {
        return R.ok(sysElementService.save(sysElement));
    }

    /**
     * 删除
     *
     * @param sysElement SysElement
     * @return R
     */
    @MartinLog("删除系统页面元素")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_element_del')")
    public R removeById(@Valid @RequestBody SysElement sysElement) {
        return R.ok(sysElementService.removeById(sysElement.getId()));
    }

    /**
     * 编辑
     *
     * @param sysElement SysElement
     * @return R
     */
    @MartinLog("编辑系统页面元素")
    @PostMapping
    @PreAuthorize("hasAuthority('sys_element_edit')")
    public R update(@Valid @RequestBody SysElement sysElement) {
        sysElement.setUpdateTime(LocalDateTime.now());
        return R.ok(sysElementService.updateById(sysElement));
    }

    /**
     * 通过ID查询
     *
     * @param sysElement SysElement
     * @return R
     */
    @MartinLog("单个查询系统页面元素")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_element_get')")
    public R getById(@RequestBody SysElement sysElement) {
        return R.ok(sysElementService.getById(sysElement.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统页面元素")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_element_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        Page page = new Page();
        SysElement sysElement = new SysElement();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, sysElement, true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(sysElementService.page(page, Wrappers.query(sysElement)));
    }


}

