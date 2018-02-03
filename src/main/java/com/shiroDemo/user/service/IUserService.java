package com.shiroDemo.user.service;

import com.shiroDemo.model.UUser;

import java.util.List;
import java.util.Set;

public interface IUserService {
    /**
     * 根据用户名获取权限id
     * @param email 用户账号
     * @return 权限id
     */
    List<Long> findPermissionIds(String email);
    /**
     * 创建用户
     */
    UUser createUser(UUser uUser);

    /**
     * 修改密码
     */
    void changePassword(Long userId,String newPassword);

    /**
     * 添加用户-角色关系
     */
    void correlationRole(Long userId,Long rolesId);

    /**
     * 删除用户-角色关系
     */
    void uncorrelationRole(Long userId,Long rolesId);

    /**
     * 根据用户名查找用户
     */
    UUser findByUsername(String username);

    /**
     * 根据用户名查找角色
     */
    Set<String> findRoles(String username);

    /**
     * 根据用户名查找权限
     */
    Set<String> findPermissions(String username);

    int deleteByPrimaryKey(Long id);
    int insertSelective(UUser record);
    UUser selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(UUser record);
    int updateByPrimaryKey(UUser record);
}
