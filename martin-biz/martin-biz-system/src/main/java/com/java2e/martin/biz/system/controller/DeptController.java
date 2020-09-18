package com.java2e.martin.biz.system.controller;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.java2e.martin.biz.system.service.DeptService;
import com.java2e.martin.common.bean.system.Dept;
import com.java2e.martin.common.bean.system.dto.DeptTreeNode;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * <p>
 * 系统部门 前端控制器
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("dept")
@Api(value = "Dept 控制器", tags = "系统部门")
public class DeptController {

    @Autowired
    private DeptService deptService;


    /**
     * 添加
     *
     * @param dept Dept
     * @return R
     */
    @MartinLog("添加系统部门")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys_dept_add')")
    public R save(@Valid @RequestBody Dept dept) {
        return R.ok(deptService.save(dept));
    }

    /**
     * 删除
     *
     * @param dept Dept
     * @return R
     */
    @MartinLog("删除系统部门")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys_dept_del')")
    public R removeById(@Valid @RequestBody Dept dept) {
        return R.ok(deptService.removeById(dept.getId()));
    }

    /**
     * 编辑
     *
     * @param dept Dept
     * @return R
     */
    @MartinLog("编辑系统部门")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys_dept_edit')")
    public R update(@Valid @RequestBody Dept dept) {
        return R.ok(deptService.updateById(dept));
    }

    /**
     * 通过ID查询
     *
     * @param dept Dept
     * @return R
     */
    @MartinLog("单个查询系统部门")
    @PostMapping("/get")
    @PreAuthorize("hasAuthority('sys_dept_get')")
    public R getById(@RequestBody Dept dept) {
        return R.ok(deptService.getById(dept.getId()));
    }

    /**
     * 分页查询
     *
     * @param params 分页以及查询参数
     * @return R
     */
    @MartinLog("分页查询系统部门")
    @PostMapping("/page")
    @PreAuthorize("hasAuthority('sys_dept_page')")
    public R getPage(@RequestBody Map params) {
        try {
            IPage<Dept> page = deptService.getPage(params);
            List menuTree = deptService.getAllDptTree();
            HashMap<String, Object> map = new HashMap<>(2);
            map.put("page", page);
            map.put("deptTree", menuTree);
            return R.ok(map);
        } catch (IllegalAccessException e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        } catch (InstantiationException e) {
            log.error("", e);
            return R.failed(ApiErrorCode.FAILED);
        }
    }

    @MartinLog("批量删除系统部门")
    @PostMapping("/deleteBatch")
    @PreAuthorize("hasAuthority('sys_dept_deleteBatch')")
    public R removeBatch(@RequestBody String ids) {
        List<String> idList = Arrays.stream(ids.split(",")).collect(Collectors.toList());
        if (CollUtil.isEmpty(idList)) {
            return R.failed("id 不能为空");
        }
        return R.ok(deptService.removeByIds(idList));
    }


}

