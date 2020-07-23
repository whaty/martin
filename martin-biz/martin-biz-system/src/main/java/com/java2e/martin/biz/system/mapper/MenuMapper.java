package com.java2e.martin.biz.system.mapper;

import com.java2e.martin.common.bean.system.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 系统菜单 Mapper 接口
 * </p>
 *
 * @author liangcan
 * @since 2019-10-18
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getAllUiMenu();

}
