package com.springboot.cloud.gen.mapper;

import com.springboot.cloud.gen.model.entity.ColumnInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: dongwei
 * @date: 2018/11/8 10:29
 */
@Repository
@Mapper
public interface ColumnInfoMapper {

    /**
     * 查询单个表的列详细信息
     * @param tableName
     * @return
     */
    List<ColumnInfo> listByTableName(@Param("tableName") String tableName);

}
