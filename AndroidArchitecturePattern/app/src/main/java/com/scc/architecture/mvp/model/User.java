package com.scc.architecture.mvp.model;

/**
  * 创建人：帅次
  * 创建时间：2021/8/16
  * 功能：实体类bean
  */
public class User {
    private String name;
    private String password;
    public User() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
