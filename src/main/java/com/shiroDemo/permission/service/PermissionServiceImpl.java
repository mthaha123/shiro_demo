package com.shiroDemo.permission.service;

import com.shiroDemo.mapper.UPermissionMapper;
import com.shiroDemo.model.UPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private UPermissionMapper permissionMapper;

    public List<UPermission> findMenus(List<Long> permissions) {
        return permissionMapper.findMenus(permissions);
    }

    public int deleteByPrimaryKey(Long id) {
        return permissionMapper.deleteByPrimaryKey(id);
    }

    public int insertSelective(UPermission record) {
        return permissionMapper.insertSelective(record);
    }

    public int updateByPrimaryKeySelective(UPermission record) {
        return permissionMapper.updateByPrimaryKeySelective(record);
    }
}
