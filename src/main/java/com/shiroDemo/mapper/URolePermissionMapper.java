package com.shiroDemo.mapper;

import com.shiroDemo.model.UPermission;
import com.shiroDemo.model.URolePermission;

import java.util.List;

public interface URolePermissionMapper {
    int insert(URolePermission record);

    int insertSelective(URolePermission record);

    void delete(URolePermission record);

    List<String> selectPermissionByRoleId(Long rid);

    List<Long> selectPermissionIdByRoleId(Long rid);
}