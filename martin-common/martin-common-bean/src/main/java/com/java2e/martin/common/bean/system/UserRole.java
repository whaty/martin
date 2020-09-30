package com.java2e.martin.common.bean.system;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.java2e.martin.common.core.annotation.BindField;
import com.java2e.martin.common.core.constant.CommonConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 系统用户角色关系
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user_role")
@ApiModel(value = "UserRole对象", description = "系统用户角色关系")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    @TableField(fill = FieldFill.INSERT)
    @NotNull(message = "用户id不能为空")
    private Integer userId;

    @ApiModelProperty(value = "角色id")
    @NotNull(message = "角色id不能为空")
    private Integer roleId;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
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
