package com.shiroDemo.mapper;

import com.shiroDemo.model.UUserRole;

public interface UUserRoleMapper {
    int insert(UUserRole record);

    int insertSelective(UUserRole record);

    void delete(UUserRole record);
}