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
 * 系统配置
 * </p>
 *
 * @author 狮少
 * @date 2020-07-24
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_config")
@ApiModel(value = "Config对象", description = "系统配置")
public class Config implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "配置值")
    private String value;

    @ApiModelProperty(value = "配置关键字")
    private String type;

    @ApiModelProperty(value = "租户")
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
