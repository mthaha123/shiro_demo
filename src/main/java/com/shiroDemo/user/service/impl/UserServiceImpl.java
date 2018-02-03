package com.shiroDemo.user.service.impl;

import com.shiroDemo.common.util.EncodingPwdUtil;
import com.shiroDemo.mapper.UUserMapper;
import com.shiroDemo.mapper.UUserRoleMapper;
import com.shiroDemo.model.UUser;
import com.shiroDemo.model.UUserRole;
import com.shiroDemo.role.service.IRoleService;
import com.shiroDemo.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UUserMapper uUserMapper;
    @Autowired
    private UUserRoleMapper uUserRoleMapper;
    @Autowired
    private IRoleService roleService;

    public List<Long> findPermissionIds(String email) {
        List<Long> roleIds= uUserMapper.findRoleIds(email);
        Set<Long> permissionIds = new HashSet<Long>();
        for(Long roleId:roleIds){
            permissionIds.addAll(roleService.selectPermissionIdByRoleId(roleId));
        }
        return new ArrayList<Long>(permissionIds);
    }

    //创建新用户
    public UUser createUser(UUser uUser) {
        String password = EncodingPwdUtil.hashService(uUser.getEmail(), uUser.getPwd());
        uUser.setPwd(password);
        uUserMapper.insertSelective(uUser);
        return null;
    }

    public void changePassword(Long userId, String newPassword) {

    }

    public void correlationRole(Long userId, Long rolesId) {
        UUserRole uUserRole = new UUserRole();
        uUserRole.setRid(rolesId);
        uUserRole.setUid(userId);
        uUserRoleMapper.insert(uUserRole);
    }

    public void uncorrelationRole(Long userId, Long rolesId) {
        UUserRole uUserRole = new UUserRole();
        uUserRole.setRid(rolesId);
        uUserRole.setUid(userId);
        uUserRoleMapper.delete(uUserRole);
    }

    public UUser findByUsername(String username) {
        return uUserMapper.findByUsername(username);
    }

    /**
     * 根据用户名查找角色权限
     * @param username 用户名
     * @return
     */
    public Set<String> findRoles(String username) {
        List<String> roles= uUserMapper.findRoles(username);
        return new HashSet<String>(roles);

    }

    public Set<String> findPermissions(String username) {
        List<Long> roleIds= uUserMapper.findRoleIds(username);
        Set<String> permissions = new HashSet<String>();
        for(Long roleId:roleIds){
            permissions.addAll(roleService.selectPermissionByRoleId(roleId));
        }
        return permissions;
    }

    public int deleteByPrimaryKey(Long id) {
        return uUserMapper.deleteByPrimaryKey(id);
    }

    public int insertSelective(UUser record) {
        return uUserMapper.insertSelective(record);
    }

    public UUser selectByPrimaryKey(Long id) {
        return uUserMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(UUser record) {
        return uUserMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UUser record) {
        return uUserMapper.updateByPrimaryKey(record);
    }
}
