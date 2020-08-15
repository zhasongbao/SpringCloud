package com.springboot.cloud.common.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author dongwei
 * @date 2020-08-13 09:48
 */
public interface BaseIService<T> extends IService<T> {

    /**
     * 分页条件查询
     * @param query
     * @return
     */
    IPage<T> pageByQuery(IPage<T> query);

}
