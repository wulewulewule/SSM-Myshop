package com.funtl.my.shop.interceptor;

import com.funtl.my.shop.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: Myshop
 * @description: 登陆拦截器(要在spring-mvc.xml中配置)
 * @author: wule
 * @create: 2019-07-31 16:17
 **/

public class LoginInterceptor implements HandlerInterceptor{
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //将登录信息放入会话中（LoginController中设置）
        User user = (User) httpServletRequest.getSession().getAttribute("user");

        //判断用户是否登录
        if(user == null){
            //未登录重定向
            httpServletResponse.sendRedirect("/login");
        }

            //放行
            return true;
        }




    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //System.out.println(modelAndView.getViewName());
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
