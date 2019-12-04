package com.funtl.my.shop.entity;

import java.io.Serializable;

/**
 * @program: Myshop
 * @description: User实体类
 * @author: wule
 * @create: 2019-07-29 16:11
 **/

public class User implements Serializable {

    private String username;
    private String password;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

