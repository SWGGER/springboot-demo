package com.hanz.stuspringbootdemo;

import com.hanz.stuspringbootdemo.dao.RoleMapper;
import com.hanz.stuspringbootdemo.domain.Permission;
import com.hanz.stuspringbootdemo.domain.Role;
import com.hanz.stuspringbootdemo.domain.User;
import com.hanz.stuspringbootdemo.service.RoleService;
import com.hanz.stuspringbootdemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

//    @Test
//    查询用户
    public void selectById() {
        User user = userService.selectById(1);
        System.out.println(user.getName());
    }


//    @Test
    public void getAllQXByUserName() {
        Map<String, Object> all = userService.getAllQXByUserName("ztt");
        for (String key : all.keySet()) {
            String row = "role_name：" + key;
            List<Permission> obj = (List) all.get(key);
            row += ",permisson:";
            for (Permission p : obj) {
                row += p.getPermission() + ",";
            }
            System.out.println(row);
        }
    }


    @Test
    public void selectByName() {
        User user = userService.selectByName("ztt");
        System.out.println(user.getPassword());
    }

}
