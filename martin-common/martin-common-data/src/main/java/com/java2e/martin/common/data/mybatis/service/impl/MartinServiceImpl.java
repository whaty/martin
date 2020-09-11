package com.java2e.martin.common.data.mybatis.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java2e.martin.common.core.constant.CommonConstants;
import com.java2e.martin.common.data.mybatis.service.MartinService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * @author 狮少
 * @version 1.0
 * @date 2020/8/19
 * @describtion MartinServiceImpl, 拓展mp的service，加入自己定义的通用方法
 * @since 1.0
 */
@Data
@Slf4j
public abstract class MartinServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements MartinService<T> {
    protected Class<T> clz;

    @Override
    public IPage<T> getPage(Map params) throws IllegalAccessException, InstantiationException {
        this.setEntity();
        Page page = new Page();
        BeanUtil.fillBeanWithMap(params, page, true);
        T entity = clz.newInstance();
        BeanUtil.fillBeanWithMap(params, entity, true);

        //修复排序的时候，驼峰不能自动转下划线问题
        List<OrderItem> orders = page.getOrders();
        if (CollUtil.isNotEmpty(orders)) {
            for (OrderItem orderItem : orders) {
                String column = orderItem.getColumn();
                if (StrUtil.isNotBlank(column)) {
                    String underlineCase = StrUtil.toUnderlineCase(column);
                    if (log.isDebugEnabled()) {
                        log.debug("column = " + underlineCase);
                    }
                    orderItem.setColumn(underlineCase);
                }
            }
        }
        QueryWrapper<T> query = Wrappers.query(entity);
        Object createTime = ReflectUtil.invoke(entity, "get" + StrUtil.upperFirst(CommonConstants.CREATE_TIME));
        if (createTime != null) {
            reflectSetEntity(entity, query, (LocalDateTime) createTime, CommonConstants.CREATE_TIME);
        }
        Object updateTime = ReflectUtil.invoke(entity, "get" + StrUtil.upperFirst(CommonConstants.UPDATE_TIME));
        if (updateTime != null) {
            reflectSetEntity(entity, query, (LocalDateTime) updateTime, CommonConstants.UPDATE_TIME);
        }
        return this.page(page, query);
    }

    /**
     * 反射设置entity中的新增、修改时间为null,不然mybatis-plus会自己增加精确匹配
     *
     * @param entity
     * @param query
     * @param dateTime
     * @param column
     * @throws IllegalAccessException
     */
    private void reflectSetEntity(T entity, QueryWrapper<T> query, LocalDateTime dateTime, String column) throws IllegalAccessException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        query.like(StrUtil.toUnderlineCase(column), dtf.format(dateTime));
        try {
            Field field = entity.getClass().getDeclaredField(column);
            field.setAccessible(true);
            field.set(entity, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 每个子类都必须调用该方法
     *
     * @return
     */
    protected abstract void setEntity();
}
