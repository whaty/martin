package com.java2e.martin.biz.system.service;

import com.java2e.martin.common.bean.system.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.java2e.martin.common.bean.system.dto.DeptTreeNode;
import com.java2e.martin.common.data.mybatis.service.MartinService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 系统部门 服务类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Transactional(rollbackFor = Exception.class)
public interface DeptService extends MartinService<Dept> {

    /**
     * 获取系统所有菜单树
     *
     * @return
     */
    List getAllDptTree();

}
