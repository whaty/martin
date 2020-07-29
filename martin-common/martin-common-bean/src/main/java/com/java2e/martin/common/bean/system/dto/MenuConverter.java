package com.java2e.martin.common.bean.system.dto;

import com.java2e.martin.common.bean.system.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ap.shaded.freemarker.template.utility.StringUtil;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/9/19
 * @describtion MenuConverter
 * @since 1.0
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
    @Mappings({
            @Mapping(source = "uiKey", target = "key"),
    })
    MenuTreeNode po2dto(Menu menu);

    /**
     * 数据库node转页面需要的node,批量转换
     *
     * @param list
     * @return
     */
    List<MenuTreeNode> po2dto(List<Menu> list);
}
