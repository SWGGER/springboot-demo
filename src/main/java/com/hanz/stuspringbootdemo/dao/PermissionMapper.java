package com.hanz.stuspringbootdemo.dao;

import com.hanz.stuspringbootdemo.domain.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {
    int insertPermission(Permission permission);

    int deletePermission(Integer permission_id);

    int updatePermission(Permission permission);

    Permission selectPermissionById(Integer permission_id);

    List<Permission> getPermissionByRoleId(int role_id);

}
