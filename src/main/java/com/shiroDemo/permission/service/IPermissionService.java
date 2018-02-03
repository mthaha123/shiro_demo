package com.shiroDemo.permission.service;

import com.shiroDemo.model.UPermission;

import java.util.List;
import java.util.Set;

public interface IPermissionService {
    /**
     * 根据用户权限获得菜单
     * @param permissions 权限
     * @return 权限详情（菜单信息）
     */
    List<UPermission> findMenus(List<Long> permissions);

    /**
     * 根据权限id删除权限
     * @param id 权限id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加权限信息
     * @param record 权限信息
     * @return
     */
    int insertSelective(UPermission record);

    /**
     * 根据权限id更新权限信息
     * @param record 权限信息
     * @return
     */
    int updateByPrimaryKeySelective(UPermission record);

}
