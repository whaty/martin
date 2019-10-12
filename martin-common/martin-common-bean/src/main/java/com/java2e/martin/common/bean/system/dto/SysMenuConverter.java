package com.java2e.martin.common.bean.system.dto;

import com.java2e.martin.common.bean.system.SysMenu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/9/19
 * @Describtion: SysMenuConverter
 */
@Mapper
public interface SysMenuConverter {
    SysMenuConverter INSTANCE = Mappers.getMapper(SysMenuConverter.class);

    /**
     * 数据库node转页面需要的node
     *
     * @param sysMenu
     * @return
     */
    MenuTreeNode po2dto(SysMenu sysMenu);

    /**
     * 数据库node转页面需要的node,批量转换
     *
     * @param list
     * @return
     */
    List<MenuTreeNode> po2dto(List<SysMenu> list);
}
