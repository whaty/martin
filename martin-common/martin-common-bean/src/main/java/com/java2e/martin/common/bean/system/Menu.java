package com.java2e.martin.common.bean.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统菜单
 * </p>
 *
 * @author liangcan
 * @since 2019-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
@ApiModel(value = "Menu对象", description = "系统菜单")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "权限编码，以menu_开头")
    private String authority;

    @ApiModelProperty(value = "前端URL")
    private String path;

    @ApiModelProperty(value = "父菜单ID")
    private Integer parentId;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "国际化字段")
    private String locale;

    @ApiModelProperty(value = "父菜单路径")
    private String parentKey;

    @ApiModelProperty(value = "前端组件")
    private String component;

    @ApiModelProperty(value = "是否隐藏子菜单")
    private Boolean hideChildrenInMenu;

    @ApiModelProperty(value = "是否隐藏菜单")
    private Boolean hideInMenu;

    @ApiModelProperty(value = "任意值")
    private String uiKey;

    @ApiModelProperty(value = "排序值")
    private Integer sort;

    @ApiModelProperty(value = "所属租户")
    private Integer tenantId;

    @ApiModelProperty(value = "删除标识（0-正常,1-删除）")
    @TableLogic
    private String delFlag;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "修改人")
    private String updater;


}
