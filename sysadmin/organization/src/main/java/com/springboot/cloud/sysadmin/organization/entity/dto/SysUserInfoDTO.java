package com.springboot.cloud.sysadmin.organization.entity.dto;

import com.springboot.cloud.sysadmin.organization.entity.po.User;
import lombok.Data;

import java.util.List;

/**
 * @author: dongwei
 * @date: 2020/08/15 13:35
 */
@Data
public class SysUserInfoDTO {

    private User sysUser;

    private List<String> roles;

    private List<String> permissions;
}
