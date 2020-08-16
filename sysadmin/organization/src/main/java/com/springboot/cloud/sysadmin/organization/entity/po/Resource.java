package com.springboot.cloud.sysadmin.organization.entity.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.springboot.cloud.common.web.entity.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resource extends BasePo {
    private String code;
    private String type;
    private String url;
    private String method;
    private String name;
    private String description;
    private String resourceGroup;
    private String color;
    private int parentId;
    private String component;
    private int sort;
    @TableLogic
    private String deleted;
}
