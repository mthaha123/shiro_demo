package com.shiroDemo.role.service;

import com.shiroDemo.mapper.URoleMapper;
import com.shiroDemo.mapper.URolePermissionMapper;
import com.shiroDemo.model.URole;
import com.shiroDemo.model.URolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private URoleMapper roleMapper;
    @Autowired
    private URolePermissionMapper rolePermissionMapper;


    public int insertSelective(URole record) {
        return roleMapper.insertSelective(record);
    }

    public int updateByPrimaryKeySelective(URole record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    public int deleteByPrimaryKey(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    public int insertRolePermission(URolePermission record) {
        return rolePermissionMapper.insert(record);
    }

    public void deleteRolePermission(URolePermission record) {
        rolePermissionMapper.delete(record);
    }

    public List<String> selectPermissionByRoleId(Long rid) {
        return rolePermissionMapper.selectPermissionByRoleId(rid);
    }

    public List<Long> selectPermissionIdByRoleId(Long rid) {
        return rolePermissionMapper.selectPermissionIdByRoleId(rid);
    }


}
