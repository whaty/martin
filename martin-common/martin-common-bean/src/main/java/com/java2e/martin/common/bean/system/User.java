package com.java2e.martin.common.bean.system;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;

import com.java2e.martin.common.core.annotation.BindDict;
import com.java2e.martin.common.core.annotation.BindField;
import com.java2e.martin.common.core.constant.CommonConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel(value = "User对象", description = "系统用户")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String pwd;

    @ApiModelProperty(value = "随机盐")
    private String salt;

    @ApiModelProperty(value = "年纪")
    private Integer age;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "签名")
    private String signature;

    @ApiModelProperty(value = "头衔")
    private String title;

    @ApiModelProperty(value = "分类")
    private String classification;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "电话")
    private String phone;

    @BindField(entity = Dept.class, field = "name")
    @ApiModelProperty(value = "部门ID")
    private Integer deptId;

    @ApiModelProperty(value = "微信openid")
    private String wxOpenid;

    @ApiModelProperty(value = "QQ openid")
    private String qqOpenid;

    @ApiModelProperty(value = "所属租户")
    private Integer tenantId;

    @ApiModelProperty(value = "0-正常，9-锁定")
    private String lockFlag;

    @ApiModelProperty(value = "删除标识（0-正常,1-删除）")
    @TableLogic
    private String delFlag;

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
