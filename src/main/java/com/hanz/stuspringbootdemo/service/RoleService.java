package com.hanz.stuspringbootdemo.service;

import com.hanz.stuspringbootdemo.domain.Permission;
import com.hanz.stuspringbootdemo.domain.Role;

import java.util.List;

public interface RoleService {

    int insertRole(Role role);

    int deleteRole(Integer role_id);

    int updateRole(Role role);

    Role selectRoleById(Integer role_id);

    List<Permission> getPermissionsByRoleId(int role_id);

    List<Role> getRoleByUserName(String username);

}
