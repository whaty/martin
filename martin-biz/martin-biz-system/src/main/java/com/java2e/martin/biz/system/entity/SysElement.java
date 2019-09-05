package com.java2e.martin.biz.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统页面元素
 * </p>
 *
 * @author liangcan
 * @since 2019-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_element")
@ApiModel(value="SysElement对象", description="系统页面元素")
public class SysElement implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "页面元素名称")
    private String name;

    @ApiModelProperty(value = "页面元素编码")
    private String code;

    @ApiModelProperty(value = "页面元素路径")
    private String url;

    @ApiModelProperty(value = "排序值")
    private Integer sort;

    @ApiModelProperty(value = "所属租户")
    private Integer tenantId;

    @ApiModelProperty(value = "删除标识（0-正常,1-删除）")
    private String delFlag;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}