package com.springboot.cloud.gen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.cloud.gen.mapper.TableInfoMapper;
import com.springboot.cloud.gen.model.entity.TableInfo;
import com.springboot.cloud.gen.model.query.TableInfoQuery;
import com.springboot.cloud.gen.service.ITableInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: dongwei
 * @date: 2018/11/8 10:05
 */
@Service
public class TableInfoServiceImpl extends ServiceImpl<TableInfoMapper, TableInfo> implements ITableInfoService {

    @Autowired
    private TableInfoMapper tableInfoMapper;

    @Override
    public TableInfoQuery pageByQuery(TableInfoQuery query) {
        tableInfoMapper.pageByQuery(query);
        return query;
    }

    @Override
    public TableInfo getOne(String tableName) {
        return tableInfoMapper.getOne(tableName);
    }
}
