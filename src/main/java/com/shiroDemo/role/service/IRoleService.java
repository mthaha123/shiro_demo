package com.shiroDemo.role.service;

import com.shiroDemo.model.URole;
import com.shiroDemo.model.URolePermission;

import java.util.List;

public interface IRoleService {
    /**
     * 添加角色信息
     * @param record 角色信息
     * @return
     */
    int insertSelective(URole record);

    /**
     * 更新角色信息
     * @param record 角色信息
     * @return
     */
    int updateByPrimaryKeySelective(URole record);

    /**
     * 根据角色id删除角色信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 根据角色id、权限id添加新的权限
     * @param record 角色权限信息
     * @return
     */
    int insertRolePermission(URolePermission record);

    /**
     * 删除绑定的权限
     * @param record 角色权限信息
     */
    void deleteRolePermission(URolePermission record);

    /**
     * 根据角色id获取权限信息
     * @param rid 角色id
     * @return 权限集合
     */
    List<String> selectPermissionByRoleId(Long rid);

    /**
     * 根据角色id获取权限id
     * @param rid 角色id
     * @return 权限id
     */
    List<Long> selectPermissionIdByRoleId(Long rid);
}
