package com.java2e.martin.biz.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java2e.martin.common.bean.system.Dict;
import com.java2e.martin.biz.system.service.DictService;
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
 * @since 2019-10-18
 */
@Slf4j
@RestController
@RequestMapping("dict")
@Api(value = "Dict 控制器", tags = "系统字典")
public class DictController {

    @Autowired
    private DictService dictService;


    /**
     * 添加
     *
     * @param dict Dict
     * @return R
     */
    @MartinLog("添加系统字典")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_dict_add')")
    public R save(@Valid @RequestBody Dict dict) {
        return R.ok(dictService.save(dict));
    }

    /**
     * 删除
     *
     * @param dict Dict
     * @return R
     */
    @MartinLog("删除系统字典")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_dict_del')")
    public R removeById(@Valid @RequestBody Dict dict) {
        return R.ok(dictService.removeById(dict.getId()));
    }

    /**
     * 编辑
     *
     * @param dict Dict
     * @return R
     */
    @MartinLog("编辑系统字典")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys_dict_edit')")
    public R update(@Valid @RequestBody Dict dict) {
        dict.setUpdateTime(LocalDateTime.now());
        return R.ok(dictService.updateById(dict));
    }

    /**
     * 通过ID查询
     *
     * @param dict Dict
     * @return R
     */
    @MartinLog("单个查询系统字典")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_dict_get')")
    public R getById(@RequestBody Dict dict) {
        return R.ok(dictService.getById(dict.getId()));
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
        Dict dict  = new Dict();
        try {
            BeanUtil.fillBeanWithMap(params, page, true);
            BeanUtil.fillBeanWithMap(params, dict, true);
        } catch (Exception e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        }
        return R.ok(dictService.page(page, Wrappers.query(dict)));
    }


}

