package com.java2e.martin.common.bean.system.dto;

import com.java2e.martin.common.bean.system.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/9/19
 * @Describtion: MenuConverter
 */
@Mapper
public interface MenuConverter {
    MenuConverter INSTANCE = Mappers.getMapper(MenuConverter.class);

    /**
     * 数据库node转页面需要的node
     *
     * @param menu
     * @return
     */
    MenuTreeNode po2dto(Menu menu);

    /**
     * 数据库node转页面需要的node,批量转换
     *
     * @param list
     * @return
     */
    List<MenuTreeNode> po2dto(List<Menu> list);
}
