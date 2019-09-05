package com.hanz.stuspringbootdemo;

import com.hanz.stuspringbootdemo.domain.Permission;
import com.hanz.stuspringbootdemo.domain.Role;
import com.hanz.stuspringbootdemo.service.PermissionService;
import com.hanz.stuspringbootdemo.service.RoleService;
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
public class PermissionServiceTests {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void insertPermission() {
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",-1);
        Permission permission = new Permission();
        permission.setId(1);
        permission.setRole_id(1);
        permission.setPermission("administrator");
        int count = permissionService.insertPermission(permission);
        if(count > 0){
            result.put("code",0);
        }
        System.out.println(result);
    }

//    @Test
    public void updatePermission() {
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",-1);
        Permission permission = new Permission();
        permission.setId(1);
        permission.setRole_id(2);
        permission.setPermission("super_ administrator");
        int count = permissionService.updatePermission(permission);
        if(count > 0){
            result.put("code",0);
        }
        System.out.println(result);
    }

//    @Test
    public void selectPermissionById() {
        Map<String,Object> result = new HashMap<String, Object>();
        Permission permission= permissionService.selectPermissionById(1);
        System.out.println(permission.getPermission());
    }

//    @Test
    public void deletePermission() {
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",-1);
        int count = permissionService.deletePermission(1);
        if(count > 0){
            result.put("code",0);
        }
        System.out.println(result);
    }

    @Test
    public void getPermissionByRoleId() {
        List<Permission> list = new ArrayList<>();
        list = permissionService.getPermissionByRoleId(1);
        System.out.println(list);
    }
}
