package com.java2e.martin.biz.system.controller;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.java2e.martin.biz.system.service.ElementService;
import com.java2e.martin.common.bean.system.Element;
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
 * 系统页面元素 前端控制器
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("element")
@Api(value = "Element 控制器", tags = "系统页面元素")
public class ElementController {

    @Autowired
    private ElementService elementService;


    /**
     * 添加
     *
     * @param element Element
     * @return R
     */
    @MartinLog("添加系统页面元素")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_element_add')")
    public R save(@Valid @RequestBody Element element) {
        return R.ok(elementService.save(element));
    }

    /**
     * 删除
     *
     * @param element Element
     * @return R
     */
    @MartinLog("删除系统页面元素")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_element_del')")
    public R removeById(@Valid @RequestBody Element element) {
        return R.ok(elementService.removeById(element.getId()));
    }

    /**
     * 编辑
     *
     * @param element Element
     * @return R
     */
    @MartinLog("编辑系统页面元素")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys_element_edit')")
    public R update(@Valid @RequestBody Element element) {
        return R.ok(elementService.updateById(element));
    }

    /**
     * 通过ID查询
     *
     * @param element Element
     * @return R
     */
    @MartinLog("单个查询系统页面元素")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_element_get')")
    public R getById(@RequestBody Element element) {
        return R.ok(elementService.getById(element.getId()));
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
        try {
            return R.ok(elementService.getPage(params));
        } catch (IllegalAccessException e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        } catch (InstantiationException e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        }
    }

    @MartinLog("批量删除系统页面元素")
    @PostMapping("/deleteBatch")
    @PreAuthorize("hasAuthority('sys_element_deleteBatch')")
    public R removeBatch(@RequestBody String ids) {
        List<String> idList = Arrays.stream(ids.split(",")).collect(Collectors.toList());
        if (CollUtil.isEmpty(idList)) {
            return R.failed("id 不能为空");
        }
        return R.ok(elementService.removeByIds(idList));
    }

}

