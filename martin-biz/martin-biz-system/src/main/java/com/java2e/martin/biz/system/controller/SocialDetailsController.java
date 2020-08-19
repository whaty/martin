package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.common.bean.system.SocialDetails;
import com.java2e.martin.biz.system.service.SocialDetailsService;
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
 * @author 狮少
 * @date 2019-10-18
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("social-details")
@Api(value = "SocialDetails 控制器", tags = "系统社交账号")
public class SocialDetailsController {

    @Autowired
    private SocialDetailsService socialDetailsService;


    /**
     * 添加
     *
     * @param socialDetails SocialDetails
     * @return R
     */
    @MartinLog("添加系统社交账号")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_social_details_add')")
    public R save(@Valid @RequestBody SocialDetails socialDetails) {
        return R.ok(socialDetailsService.save(socialDetails));
    }

    /**
     * 删除
     *
     * @param socialDetails SocialDetails
     * @return R
     */
    @MartinLog("删除系统社交账号")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_social_details_del')")
    public R removeById(@Valid @RequestBody SocialDetails socialDetails) {
        return R.ok(socialDetailsService.removeById(socialDetails.getId()));
    }

    /**
     * 编辑
     *
     * @param socialDetails SocialDetails
     * @return R
     */
    @MartinLog("编辑系统社交账号")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys_social_details_edit')")
    public R update(@Valid @RequestBody SocialDetails socialDetails) {
        return R.ok(socialDetailsService.updateById(socialDetails));
    }

    /**
     * 通过ID查询
     *
     * @param socialDetails SocialDetails
     * @return R
     */
    @MartinLog("单个查询系统社交账号")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_social_details_get')")
    public R getById(@RequestBody SocialDetails socialDetails) {
        return R.ok(socialDetailsService.getById(socialDetails.getId()));
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
        try {
            return R.ok(socialDetailsService.getPage(params));
        } catch (IllegalAccessException e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        } catch (InstantiationException e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        }
    }


}

