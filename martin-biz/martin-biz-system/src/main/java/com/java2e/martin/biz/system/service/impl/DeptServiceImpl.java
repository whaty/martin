package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.Dept;
import com.java2e.martin.biz.system.mapper.DeptMapper;
import com.java2e.martin.biz.system.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java2e.martin.common.data.mybatis.service.impl.MartinServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统部门 服务实现类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Service
public class DeptServiceImpl extends MartinServiceImpl<DeptMapper, Dept> implements DeptService {

    @Override
    protected void setEntity() {
        this.clz = Dept.class;
    }
}
