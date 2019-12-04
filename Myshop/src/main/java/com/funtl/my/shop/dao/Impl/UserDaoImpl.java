package com.funtl.my.shop.dao.Impl;


import com.funtl.my.shop.dao.UserDao;
import com.funtl.my.shop.entity.User;
import org.springframework.stereotype.Component;

/**
 * @program: Myshop
 * @description: User接口实体类
 * @author: wule
 * @create: 2019-07-29 16:00
 **/

@Component
public class UserDaoImpl implements UserDao {

    public User getUser(String email, String password) {
        User user = new User();
        if("admin@qq.com".equals(email)){
            if("admin".equals(password)){
                user.setEmail("admin@qq.com");
                user.setUsername("admin");
            }
        }
        return user;
    }
}
