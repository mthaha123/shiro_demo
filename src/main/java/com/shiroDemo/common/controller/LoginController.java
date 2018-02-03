package com.shiroDemo.common.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录控制器，主要使用shiro authc拦截器进行登录，登录失败将错误存到shiroLoginFailure属性中，这里进行
 * 获取错误信息并显示到登录页面
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String showLoginForm(HttpServletRequest request, Model model,String pwd,String email){
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)){
            error = "用户名/密码错误";
        }else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)){
            error = "用户名/密码错误";
        }else if (exceptionClassName != null){
            error = "其他错误"+exceptionClassName;
        }
        model.addAttribute("error",error);
        return "login";
    }
}
