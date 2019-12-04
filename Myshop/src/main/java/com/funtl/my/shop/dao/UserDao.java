package com.funtl.my.shop.dao;


import com.funtl.my.shop.entity.User;

/**
* @Description: 根据邮箱和密码获取用户信息 
* @Param:  
* @return:  
* @Author: wule 
* @Date: 2019/7/29 
*/ 
public interface UserDao {

    public User getUser(String email, String password);
}
