package com.java2e.martin.common.bean.system;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.java2e.martin.common.core.annotation.BindField;
import com.java2e.martin.common.core.constant.CommonConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统菜单
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 * @since 1.0
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

    @ApiModelProperty(value = "重定向操作")
    private String target;

    @ApiModelProperty(value = "绑定表名")
    private String tableName;

    @BindField(entity = Menu.class,field = "name")
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

    @ApiModelProperty(value = "是否为演示数据,0:不区分环境，1：演示，2：正式")
    private Integer dev;

    @ApiModelProperty(value = "是否已生成按钮")
    private Boolean flagIsGentOperation;

    @ApiModelProperty(value = "所属租户")
    private Integer tenantId;

    @ApiModelProperty(value = "删除标识（0-正常,1-删除）")
    @TableLogic
    private String delFlag;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @BindField(entity = User.class, field = CommonConstants.USER_USERNAME)
    @ApiModelProperty(value = "创建人")
    @TableField(fill = FieldFill.INSERT)
    private String creator;

    @BindField(entity = User.class, field = CommonConstants.USER_USERNAME)
    @ApiModelProperty(value = "修改人")
    @TableField(fill = FieldFill.UPDATE)
    private String updater;


}
