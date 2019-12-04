package com.funtl.my.shop.web.admin.web.controller;

import com.funtl.my.shop.commons.constant.ConstantUtils;
import com.funtl.my.shop.domain.TbUser;
import com.funtl.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: my-shop
 * @description: 登录
 * @author: wule
 * @create: 2019-08-01 15:37
 **/

@Controller
public class LoginController {

    @Autowired
    private TbUserService tbUserService;

    /*
    * 跳转登录页面
    * */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    //登录逻辑
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest httpServletRequest, Model model) {  //@RequestParam(required = true)请求参数是必须的
        TbUser tbUser = tbUserService.login(email, password);
        //登陆失败
        if (tbUser == null) {
            //model.addAttribute("message","用户名或密码错误，请重新登陆！");
            model.addAttribute("message","用户名或密码错误");
            return login();
        } else {
            //成功
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER,tbUser);
            return "redirect:/main";


        }


        /* User user = userService.login(email, password);

        //登陆失败
        if (user == null) {
            return login();
        } else {
            //登陆成功

            //登录信息放入会话中
            //httpServletRequest.getSession().setAttribute("user",user);
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER, user);
            return "redirect:/main";
*/


        //面向对象原则，单一原则，最少支持原则

    }
}

