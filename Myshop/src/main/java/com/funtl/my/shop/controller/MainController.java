package com.funtl.my.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: Myshop
 * @description: 跳转到首页
 * @author: wule
 * @create: 2019-07-31 09:54
 **/

@Controller
public class MainController {

    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String main(){
    return "main";
  }
}