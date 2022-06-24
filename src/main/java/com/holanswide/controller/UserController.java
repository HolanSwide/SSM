package com.holanswide.controller;

import com.holanswide.factory.SpringBean;
import com.holanswide.mapper.UserMapImp;
import com.holanswide.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/6/24 0:00
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/me")
    public String getMe(Model model) {
        UserMapImp umi = SpringBean.getAc().getBean("userMapImp", UserMapImp.class);
        model.addAttribute("users", umi.queryUserAll());
        return "hello";
    }

    @GetMapping("/login")
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        System.out.println("> Username: " + username + " , Password: " + password);
        UserMapImp umi = SpringBean.getAc().getBean("userMapImp", UserMapImp.class);
        User nowUser = umi.queryUserByUsername(username);
        if (nowUser != null) {
            model.addAttribute("me", nowUser);
            return "hello";
        } else {
            model.addAttribute("msg", "登陆失败，请检查账号密码是否正确，或注册");
            return "index";
        }
    }

    @GetMapping("/register")
    public String doRegister(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        User user = (User) SpringBean.getAc().getBean("user", User.class);
        user.setUsername(username);
        user.setPassword(password);
        UserMapImp umi = SpringBean.getAc().getBean("userMapImp", UserMapImp.class);
        int res = umi.addUser(user);
        String msg = null;
        switch (res) {
            case 1:
                msg = "注册成功！";
                break;
            case 2:
                msg = "用户名重复！";
                break;
            default:
                msg = "注册失败，请重试...";
                break;
        }
        model.addAttribute("msg", msg);
        return "index";
    }
}
