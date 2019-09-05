package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.biz.system.entity.SysSocialDetails;
import com.java2e.martin.biz.system.service.SysSocialDetailsService;
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
 * 系统社交账号 前端控制器
 * </p>
 *
 * @author liangcan
 * @since 2019-09-05
 */
@Slf4j
@RestController
@RequestMapping("/sys-social-details")
@Api(value = "SysSocialDetails 控制器", tags = "系统社交账号")
public class SysSocialDetailsController {

    @Autowired
    private SysSocialDetailsService sysSocialDetailsService;


    /**
     * 添加
     *
     * @param sysSocialDetails SysSocialDetails
     * @return R
     */
    @MartinLog("添加系统社交账号")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_social_details_add')")
    public R save(@Valid @RequestBody SysSocialDetails sysSocialDetails) {
        return R.ok(sysSocialDetailsService.save(sysSocialDetails));
    }

    /**
     * 删除
     *
     * @param sysSocialDetails SysSocialDetails
     * @return R
     */
    @MartinLog("删除系统社交账号")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_social_details_del')")
    public R removeById(@Valid @RequestBody SysSocialDetails sysSocialDetails) {
        return R.ok(sysSocialDetailsService.removeById(sysSocialDetails.getId()));
    }

    /**
     * 编辑
     *
     * @param sysSocialDetails SysSocialDetails
     * @return R
     */
    @MartinLog("编辑系统社交账号")
    @PostMapping
    @PreAuthorize("hasAuthority('sys_social_details_edit')")
    public R update(@Valid @RequestBody SysSocialDetails sysSocialDetails) {
        sysSocialDetails.setUpdateTime(LocalDateTime.now());
        return R.ok(sysSocialDetailsService.updateById(sysSocialDetails));
    }

    /**
     * 通过ID查询
     *
     * @param sysSocialDetails SysSocialDetails
     * @return R
     */
    @MartinLog("单个查询系统社交账号")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_social_details_get')")
    public R getById(@RequestBody SysSocialDetails sysSocialDetails) {
        return R.ok(sysSocialDetailsService.getById(sysSocialDetails.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统社交账号")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_social_details_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        Page page = new Page();
        SysSocialDetails sysSocialDetails = new SysSocialDetails();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, sysSocialDetails, true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(sysSocialDetailsService.page(page, Wrappers.query(sysSocialDetails)));
    }


}

