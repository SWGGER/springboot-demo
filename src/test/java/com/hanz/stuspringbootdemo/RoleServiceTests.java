package com.hanz.stuspringbootdemo;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTests {

    @Autowired
    private RoleService roleService;

//    @Test
    public void insertRole() {
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",-1);
        Role role = new Role();
        role.setId(1);
        role.setRole_name("CLERK");
        role.setUser_id(1);
        int count = roleService.insertRole(role);
        if(count > 0){
            result.put("code",0);
        }
        System.out.println(result);
    }

//    @Test
    public void updateRole() {
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",-1);
        Role role = new Role();
        role.setId(1);
        role.setRole_name("SALESMAN");
        role.setUser_id(1);
        int count = roleService.updateRole(role);
        if(count > 0){
            result.put("code",0);
        }
        System.out.println(result);
    }

//    @Test
    public void selectRoleById() {
        Map<String,Object> result = new HashMap<String, Object>();
        Role role = roleService.selectRoleById(1);
        System.out.println(role.getRole_name());
    }

//    @Test
    public void deleteRole() {
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",-1);
        int count = roleService.deleteRole(1);
        if(count > 0){
            result.put("code",0);
        }
        System.out.println(result);
    }

    @Test
//    根据user表中的用户的信息查询出role表中的职务信息
    public void getRoleByUserName() {
        List<Role> list = new ArrayList<>();
        list = roleService.getRoleByUserName("ztt");
        System.out.println(list);
    }


}
