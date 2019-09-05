package com.hanz.stuspringbootdemo.controller;


import com.hanz.stuspringbootdemo.domain.User;
import com.hanz.stuspringbootdemo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ShiroController {
    @Autowired
    private UserService userService;
    @RequestMapping("/loginShiro/{name}/{password}")
    public Object loginShiro(@PathVariable String name, @PathVariable String password){
        if(name!=null){
            User user=userService.selectByName(name);
            if(user!=null && user.getPassword().equals(password)){
                //添加用户认证信息
                Subject subject= SecurityUtils.getSubject();
                UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(name,password);
                //进行验证，这里可以捕获异常，然后返回对应信息
                subject.login(usernamePasswordToken);
                System.out.println("loginShiro:"+usernamePasswordToken);
                return "loginShiro!";
            }
        }
        //调用过logout后通过setLoginUtil重新进入该方法
        return "it's logout!";
    }

    @RequestMapping("/logout")
    public Object logout(){
        return "logout!";
    }

    @RequestMapping(value = "/index")
    public Object index(){
        return  "index!";
    }

    @RequestMapping(value = "/errorpage")
    public Object error(){
        return  "error!";
    }

    @RequestMapping(value = "/testShiro")
    public Object testShiro(){
        return "testShiro:success!";
    }

    //认证角色 logical = Logical.OR / Logical.AND(默认)
    @RequestMapping("/testAuthorityRole")
    @RequiresRoles(value = {"admin","uer"},logical = Logical.OR)
    public Object testAuthorityRole(){
        return "testAuthorityRole:success!";
    }

    @RequestMapping("/testAuthorityPermission")
    @RequiresPermissions(value = {"create","update"},logical = Logical.OR)
    public Object testAuthorityPermission(){
        return "testAuthorityPermission:success!";
    }

    //认证角色
    @RequestMapping("/testmyAuthorityRole")
    @RequiresRoles(value = {"admin","super_admin"},logical = Logical.AND)
    public Object testmyAuthorityRole(){
        return "testmyAuthorityRole:success!";
    }

    @RequestMapping("/testAuthorityRoleAndPermission")
    @RequiresRoles(value = {"super_admin","user"},logical = Logical.AND)
    @RequiresPermissions(value = {"select","update"},logical = Logical.OR)
    public Object testAuthorityRoleAndPermission(){
        return "testAuthorityRoleAndPermission:success!";
    }

}
