package com.holanswide.controller;

import com.alibaba.fastjson.JSON;
import com.holanswide.factory.SpringBean;
import com.holanswide.mapper.UserMapImp;
import com.holanswide.model.User;
import com.holanswide.service.Login;
import com.holanswide.service.Register;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/6/24 0:00
 */

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {
    @GetMapping("/me")
    public String getMe(Model model) {
        UserMapImp umi = SpringBean.getAc().getBean("userMapImp", UserMapImp.class);
        model.addAttribute("users", umi.queryUserAll());
        return "hello";
    }

    @PostMapping("/login")
    public String login(@RequestBody String obj, Model model) {
        System.out.println(obj);
        String username = JSON.parseObject(obj).getString("username");
        String password = JSON.parseObject(obj).getString("password");
        User user = SpringBean.getAc().getBean("login",Login.class).doLogin(username,password,model);
        model.addAttribute("user",user);
        System.out.println(">user:"+user);
        if(user==null) {
            return "index";
        } else return "hello";
    }

    @GetMapping("/register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        return SpringBean.getAc().getBean("register", Register.class).doRegister(username, password, model);
    }
}
