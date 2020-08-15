package com.springboot.cloud.gen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.cloud.gen.mapper.ColumnInfoMapper;
import com.springboot.cloud.gen.mapper.TableInfoMapper;
import com.springboot.cloud.gen.model.entity.ColumnInfo;
import com.springboot.cloud.gen.model.entity.TableInfo;
import com.springboot.cloud.gen.model.dto.BuildConfigDTO;
import com.springboot.cloud.gen.service.ISysGenService;
import com.springboot.cloud.gen.service.ITableInfoService;
import com.springboot.cloud.gen.util.GenUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.zip.ZipOutputStream;

/**
 * @author: dongwei
 * @date: 2018/11/8 14:48
 */
@Service
public class SysGenServiceImpl implements ISysGenService {

    @Autowired
    private TableInfoMapper tableInfoMapper;

    @Autowired
    private ColumnInfoMapper columnInfoMapper;

    @Override
    public byte[] genCodeByTableName(BuildConfigDTO buildConfigDTO) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        for (String tableName : buildConfigDTO.getTableName()) {
            //查询表信息
           TableInfo table = tableInfoMapper.getOne(tableName);
            //查询列信息
            List<ColumnInfo> columns = columnInfoMapper.listByTableName(tableName);
            //生成代码
            GenUtil.generatorCode(buildConfigDTO,table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();

    }
}
