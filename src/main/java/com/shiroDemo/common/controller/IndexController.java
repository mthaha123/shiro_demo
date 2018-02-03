package com.shiroDemo.common.controller;

import com.shiroDemo.model.UPermission;
import com.shiroDemo.model.UUser;
import com.shiroDemo.permission.service.IPermissionService;
import com.shiroDemo.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 查询菜单在前台界面显示
 */
@Controller
public class IndexController {

    @Autowired
    private IPermissionService permissionService;
    @Autowired
    private IUserService userService;
    @RequestMapping("/index")
    public String index(UUser loginUser,Model model){
        List<Long> permissionIds = userService.findPermissionIds(loginUser.getEmail());
        List<UPermission> menus = permissionService.findMenus(permissionIds);
        model.addAttribute("menus",menus);
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
