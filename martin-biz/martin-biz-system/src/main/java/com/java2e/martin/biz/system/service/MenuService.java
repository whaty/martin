package com.java2e.martin.biz.system.service;

import com.java2e.martin.common.bean.system.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.java2e.martin.common.data.mybatis.service.MartinService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 系统菜单 服务类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Transactional(rollbackFor = Exception.class)
public interface MenuService extends MartinService<Menu> {

    /**
     * 获取所有ui所需要的菜单信息
     *
     * @return List<Menu>
     */
    List<Menu> getAllUiMenu();

    /**
     * 插入Menu并返回主键
     *
     * @param menu
     * @return
     */
    Object insert(Menu menu);

}
