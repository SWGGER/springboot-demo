package com.hanz.stuspringbootdemo.controller;

import com.hanz.stuspringbootdemo.config.jedis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TestController {
    @RequestMapping(value = "/test0")
    @ResponseBody
    public Object test0(){
        return "hello world!";
    }
    //访问路径 http://localhost:8080/test0

    @RequestMapping("/restTest/{name}")
    public Object test1(@PathVariable String name){
        return "restTest:" + name;
    }
    //访问路径 http://localhost:8080/restTest/ztt

    @Autowired
    private JedisUtil jedis;
    @RequestMapping("/restJedis/{val}")
    public Object restJedis(@PathVariable String val){
        jedis.set("key-" + val,val);
        return "restJedis_OK";
    }

    //访问路径 http://localhost:8080/restJedis/ztt

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/getJDBC/{id}")
    public Object getJDBC(@PathVariable Integer id){
        String sql = "select * from user where id = " + id;
        Map<String,Object> data = jdbcTemplate.queryForMap(sql);
        return data;
    }
    //访问路径 http://localhost:8080/getJDBC/1

}
