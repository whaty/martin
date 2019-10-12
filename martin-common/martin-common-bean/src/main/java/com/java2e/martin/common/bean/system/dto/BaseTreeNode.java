package com.java2e.martin.common.bean.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/9/19
 * @Describtion: 注意，下面的bean每个属性都为必要属性，不可缺一
 * 继承此bean再添加多个属性，不会影响树结构
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "树基类")
public class BaseTreeNode implements Serializable {

    private static final long serialVersionUID = 7444637036085561618L;

    @ApiModelProperty(value = "当前节点id")
    protected int id;

    @ApiModelProperty(value = "父节点id")
    protected int parentId;

    /**
     * 名字必须为children，ant design pro  中的子节点都叫children
     */
    @ApiModelProperty(value = "子节点列表")
    protected List<BaseTreeNode> children = new ArrayList<BaseTreeNode>();

    public void add(BaseTreeNode node) {
        children.add(node);
    }
}
