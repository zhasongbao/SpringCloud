package com.springboot.cloud.common.web.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author dongwei
 * @date 2020-08-13 10:14
 */
public interface BaseMapper<T> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {


    /**
     * 分页查询
     * @param query 分页查询条件
     * @return 分页查询结果
     */
    IPage<T> pageByQuery(IPage<T> query);
}
