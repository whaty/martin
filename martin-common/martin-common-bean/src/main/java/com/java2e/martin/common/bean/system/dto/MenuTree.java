package com.java2e.martin.common.bean.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/9/19
 * @Describtion: MenuTree, 菜单树
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "菜单树")
@EqualsAndHashCode(callSuper = true)
public class MenuTree extends BaseTree {
    /**
     * 菜单图标
     */
    @ApiModelProperty(value = "菜单图标")
    private String icon;

    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称")
    private String name;

    private boolean spread = false;

    /**
     * 前端路由标识路径
     */
    @ApiModelProperty(value = "前端路由标识路径")
    private String path;


    /**
     * 权限编码
     */
    @ApiModelProperty(value = "权限编码")
    private String authority;

    /**
     * 菜单标签
     */
    @ApiModelProperty(value = "菜单标签")
    private String label;

    /**
     * 排序值
     */
    @ApiModelProperty(value = "排序值")
    private Integer sort;

}
