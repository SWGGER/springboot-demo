package com.hanz.stuspringbootdemo.controller;

import com.hanz.stuspringbootdemo.domain.User;
import com.hanz.stuspringbootdemo.service.UserService;
import com.hanz.stuspringbootdemo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //增加用户
    @RequestMapping("/addUser/{name}/{password}/{sal}")
    public Object addUser(@PathVariable String name,@PathVariable String password,@PathVariable Double sal){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",-1);
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setSal(sal);
        int count = userService.insert(user);
        if(count > 0){
            result.put("code",0);
        }
        return result;
    }

    //修改用户
    @RequestMapping("/updateUser/{id}/{name}/{password}/{sal}")
    public Object updateUser(@PathVariable Integer id,@PathVariable String name,@PathVariable String password,@PathVariable Double sal){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",-1);
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        user.setSal(sal);
        int count = userService.update(user);
        if(count > 0){
            result.put("code",0);
        }
        return result;
    }


    //查询用户
    @RequestMapping("/selectUser/{id}")
    public Object selectUser(@PathVariable Integer id){
        Map<String,Object> result = new HashMap<String, Object>();
        User user = userService.selectById(id);
        return user;
    }

    //删除用户
    @RequestMapping("/deleteUser/{id}")
    public Object deleteUser(@PathVariable Integer id){
        Map<String,Object> result = new HashMap<String, Object>();
        int count =  userService.delete(id);
        if(count > 0){
            result.put("code",0);
        }
        return result;
    }

}
