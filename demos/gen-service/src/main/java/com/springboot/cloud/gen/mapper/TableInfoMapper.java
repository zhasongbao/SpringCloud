package com.springboot.cloud.gen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.cloud.gen.model.entity.TableInfo;
import com.springboot.cloud.gen.model.query.TableInfoQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: dongwei
 * @date: 2018/11/8 09:59
 */
@Repository
@Mapper
public interface TableInfoMapper extends BaseMapper<TableInfo> {

    /**
     * 分页查询表信息
     * @param tableInfoQuery
     * @return
     */
    IPage<TableInfo> pageByQuery(TableInfoQuery tableInfoQuery);


    /**
     * 查询单个表信息
     * @param tableName
     * @return
     */
    TableInfo getOne(@Param("tableName") String tableName);

}
