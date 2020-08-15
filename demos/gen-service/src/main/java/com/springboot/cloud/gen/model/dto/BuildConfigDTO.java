package com.springboot.cloud.gen.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: dongwei
 * @date: 2019/11/4 15:52
 */
@Data
public class BuildConfigDTO {

    private String genType;

    private List<String> tableName;

    /**
     * 包名
     */
    private String packageName;

    /**
     * query类的包名
     */
    private String queryPackageName;

    /**
     * service类包名
     */
    private String servicePackageName;

    /**
     * serviceApi类包名
     */
    private String serviceApiPackageName;

    /**
     * dao的包名
     */
    private String daoPackageName;

    /**
     * mapper类包名
     */
    private String mapperPackageName;

    /**
     * controller类包名
     */
    private String controllerPackageName;

    /**
     * vue模拟名
     */
    private String vueModalName;

    /**
     * 作者名称
     */
    private String authorName;

}
