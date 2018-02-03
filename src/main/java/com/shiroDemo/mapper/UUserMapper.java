package com.shiroDemo.mapper;

import com.shiroDemo.model.UUser;

import java.util.List;
import java.util.Set;

public interface UUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UUser record);

    int insertSelective(UUser record);

    UUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UUser record);

    int updateByPrimaryKey(UUser record);

    UUser findByUsername(String email);

    List<String> findRoles(String email);

    List<Long> findRoleIds(String email);
}