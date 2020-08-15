package com.springboot.cloud.common.web.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.cloud.common.web.dao.BaseMapper;
import com.springboot.cloud.common.web.service.BaseIService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dongwei
 * @date 2020-08-13 09:48
 */
public class BaseService<K extends BaseMapper<T>, T> extends ServiceImpl<K , T> implements BaseIService<T> {

    @Autowired
    protected K baseMapper;

    /**
     * 分页条件查询
     * @param query
     * @return
     */
    @Override
    public IPage<T> pageByQuery(IPage<T> query) {
        return  baseMapper.pageByQuery(query);
    }

}
