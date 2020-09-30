package com.java2e.martin.biz.system.controller;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.java2e.martin.biz.system.service.ConfigService;
import com.java2e.martin.common.bean.system.Config;
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
 * 前端控制器
 * </p>
 *
 * @author 狮少
 * @date 2020-07-24
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("config")
@Api(value = "Config 控制器", tags = "系统配置 ")
public class ConfigController {

    @Autowired
    private ConfigService configService;


    /**
     * 添加
     *
     * @param config Config
     * @return R
     */
    @MartinLog("添加系统配置 ")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_config_add')")
    public R save(@Valid @RequestBody Config config) {
        return R.ok(configService.save(config));
    }

    /**
     * 删除
     *
     * @param config Config
     * @return R
     */
    @MartinLog("删除系统配置 ")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_config_del')")
    public R removeById(@Valid @RequestBody Config config) {
        return R.ok(configService.removeById(config.getId()));
    }

    /**
     * 编辑
     *
     * @param config Config
     * @return R
     */
    @MartinLog("编辑系统配置 ")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys_config_edit')")
    public R update(@Valid @RequestBody Config config) {
        return R.ok(configService.updateById(config));
    }

    /**
     * 通过ID查询
     *
     * @param config Config
     * @return R
     */
    @MartinLog("单个查询系统配置 ")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_config_get')")
    public R getById(@RequestBody Config config) {
        return R.ok(configService.getById(config.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统配置 ")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_config_page')")
    public R<IPage> getPage(@RequestBody Map params) {
        try {
            return R.ok(configService.getPage(params));
        } catch (IllegalAccessException e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        } catch (InstantiationException e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        }
    }

    @MartinLog("批量删除系统配置")
    @PostMapping("/deleteBatch")
    @PreAuthorize("hasAuthority('sys_config_deleteBatch')")
    public R removeBatch(@RequestBody String ids) {
        List<String> idList = Arrays.stream(ids.split(",")).collect(Collectors.toList());
        if (CollUtil.isEmpty(idList)) {
            return R.failed("id 不能为空");
        }
        return R.ok(configService.removeByIds(idList));
    }


}

