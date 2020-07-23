package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.Menu;
import com.java2e.martin.biz.system.mapper.MenuMapper;
import com.java2e.martin.biz.system.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统菜单 服务实现类
 * </p>
 *
 * @author liangcan
 * @since 2019-10-18
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> getAllUiMenu() {
        return menuMapper.getAllUiMenu();
    }
}
