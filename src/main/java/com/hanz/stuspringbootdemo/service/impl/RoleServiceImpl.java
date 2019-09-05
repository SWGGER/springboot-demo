package com.hanz.stuspringbootdemo.service.impl;

import com.hanz.stuspringbootdemo.dao.RoleMapper;
import com.hanz.stuspringbootdemo.domain.Permission;
import com.hanz.stuspringbootdemo.domain.Role;
import com.hanz.stuspringbootdemo.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@Slf4j
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int insertRole(Role role) {
        return roleMapper.insertRole(role);
    }

    @Override
    public int deleteRole(Integer role_id) {
        return roleMapper.deleteRole(role_id);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    @Override
    public Role selectRoleById(Integer role_id) {
        return roleMapper.selectRoleById(role_id);
    }



    @Override
    public List<Permission> getPermissionsByRoleId(int role_id) {
        return null;
    }

    @Override
    public List<Role> getRoleByUserName(String username) {
        return roleMapper.getRoleByUserName(username);
    }

}
