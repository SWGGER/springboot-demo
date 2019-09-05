package com.hanz.stuspringbootdemo.service;

import com.hanz.stuspringbootdemo.domain.Role;
import com.hanz.stuspringbootdemo.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    int insert(User user);

    int delete(Integer id);

    int update(User user);

    User selectById(Integer id);

    Map<String,Object> getAllQXByUserName(String username);

//    根据用户名查密码
    User selectByName(String name);

}
