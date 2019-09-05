package com.hanz.stuspringbootdemo.domain;

public class TestUser {
    private Integer id;

    private String name;

    private String password;

    private String sal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal == null ? null : sal.trim();
    }
}