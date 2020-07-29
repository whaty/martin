package com.java2e.martin.biz.system.service.impl;

import com.java2e.martin.common.bean.system.Element;
import com.java2e.martin.biz.system.mapper.ElementMapper;
import com.java2e.martin.biz.system.service.ElementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统页面元素 服务实现类
 * </p>
 *
 * @author 狮少
 * @date 2019-10-18
 */
@Service
public class ElementServiceImpl extends ServiceImpl<ElementMapper, Element> implements ElementService {

}
