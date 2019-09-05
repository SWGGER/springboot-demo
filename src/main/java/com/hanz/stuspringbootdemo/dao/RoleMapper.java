package com.hanz.stuspringbootdemo.dao;

import com.hanz.stuspringbootdemo.domain.Permission;
import com.hanz.stuspringbootdemo.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    int insertRole(Role role);

    int deleteRole(Integer role_id);

    int updateRole(Role role);

    Role selectRoleById(Integer role_id);

    List<Role> getRoleByUserName(String username);


}
