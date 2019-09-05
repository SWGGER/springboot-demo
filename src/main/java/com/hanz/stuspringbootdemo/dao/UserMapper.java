package com.hanz.stuspringbootdemo.dao;

import com.hanz.stuspringbootdemo.domain.Role;
import com.hanz.stuspringbootdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    int insert(User user);

    int delete(Integer id);

    int update(User user);

    User selectById(Integer id);

    Map<String,Object> getAllQXByUserName(String username);

    User selectByName(String name);

}