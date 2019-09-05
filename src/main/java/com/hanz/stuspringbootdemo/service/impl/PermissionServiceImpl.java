package com.hanz.stuspringbootdemo.service.impl;

import com.hanz.stuspringbootdemo.dao.PermissionMapper;
import com.hanz.stuspringbootdemo.domain.Permission;
import com.hanz.stuspringbootdemo.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int insertPermission(Permission permission) {
        return permissionMapper.insertPermission(permission);
    }

    @Override
    public int deletePermission(Integer permission_id) {
        return permissionMapper.deletePermission(permission_id);
    }

    @Override
    public int updatePermission(Permission permission) {
        return permissionMapper.updatePermission(permission);
    }

    @Override
    public Permission selectPermissionById(Integer permission_id) {
        return permissionMapper.selectPermissionById(permission_id);
    }

    @Override
    public List<Permission> getPermissionByRoleId(int role_id) {
        return permissionMapper.getPermissionByRoleId(role_id);
    }


}

