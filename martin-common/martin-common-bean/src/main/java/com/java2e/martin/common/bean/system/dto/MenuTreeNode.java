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
public class MenuTreeNode extends BaseTreeNode {
    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "权限编码，以menu_开头")
    private String authority;

    @ApiModelProperty(value = "前端URL")
    private String path;

    @ApiModelProperty(value = "图标")
    private String icon;

    private String locale;

    @ApiModelProperty(value = "前端组件")
    private String component;

    @ApiModelProperty(value = "排序值")
    private Integer sort;

}