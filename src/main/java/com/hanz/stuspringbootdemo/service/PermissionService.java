package com.hanz.stuspringbootdemo.service;

import com.hanz.stuspringbootdemo.domain.Permission;

import java.util.List;

public interface PermissionService {

    int insertPermission(Permission permission);

    int deletePermission(Integer permission_id);

    int updatePermission(Permission permission);

    Permission selectPermissionById(Integer permission_id);

    List<Permission> getPermissionByRoleId(int role_id);

}
