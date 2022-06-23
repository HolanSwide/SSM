package com.holanswide.controller;

import com.holanswide.factory.SpringBean;
import com.holanswide.mapper.UserMapImp;
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
        UserMapImp umi = (UserMapImp)SpringBean.getBean("userMapImp",UserMapImp.class);
        model.addAttribute("users", umi.queryUserAll());
        return "hello";
    }
}
