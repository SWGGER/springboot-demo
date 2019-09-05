package com.hanz.stuspringbootdemo.service.impl;

import com.hanz.stuspringbootdemo.dao.PermissionMapper;
import com.hanz.stuspringbootdemo.dao.RoleMapper;
import com.hanz.stuspringbootdemo.dao.UserMapper;
import com.hanz.stuspringbootdemo.domain.Role;
import com.hanz.stuspringbootdemo.domain.User;
import com.hanz.stuspringbootdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Primary
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }


    @Override
    public Map<String, Object> getAllQXByUserName(String username) {
        List<Role> roles = roleMapper.getRoleByUserName(username);
        Map<String, Object> role_map = new HashMap<>();
        for (Role r : roles) {
            role_map.put(r.getRole_name(),permissionMapper.getPermissionByRoleId(r.getId()));
        }
        return role_map;
    }

    @Override
    public User selectByName(String name) {
        return userMapper.selectByName(name);
    }
}
