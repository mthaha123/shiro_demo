package com.shiroDemo.mapper;

import com.shiroDemo.model.UPermission;

import java.util.List;

public interface UPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UPermission record);

    int insertSelective(UPermission record);

    UPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UPermission record);

    int updateByPrimaryKey(UPermission record);

    List<UPermission> findMenus(List<Long> permissionsId);
}