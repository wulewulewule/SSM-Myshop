package com.funtl.my.shop.service.impl;

import com.funtl.my.shop.commons.SpringContext;
import com.funtl.my.shop.dao.UserDao;
import com.funtl.my.shop.entity.User;
import com.funtl.my.shop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @program: Myshop
 * @description: 登录类
 * @author: wule
 * @create: 2019-07-29 15:29
 **/

@Service
public class UserServiceImpl implements UserService {

   private UserDao userDao = SpringContext.getBean("userDaoImpl");

    public User login(String email, String password) {
        return userDao.getUser(email, password);

    }
}
