package com.springboot.cloud.gen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.cloud.gen.model.dto.BuildConfigDTO;

/**
 * @author: dongwei
 * @date: 2018/11/8 14:45
 */
public interface ISysGenService  {

    /**
     * 根据表名生成代码
     * @param buildConfigDTO
     * @return
     */
    byte[] genCodeByTableName(BuildConfigDTO buildConfigDTO);

}
