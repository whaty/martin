package com.java2e.martin.biz.system.mapper;

import com.java2e.martin.common.bean.system.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java2e.martin.common.core.api.R;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户id查询用户所有信息
     *
     * @param id
     * @return
     */
    List<Map> currentUser(Object id);
}
