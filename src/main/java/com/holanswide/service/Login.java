package com.holanswide.service;

import com.holanswide.factory.SpringBean;
import com.holanswide.mapper.UserMapImp;
import com.holanswide.model.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/8/3 10:50
 */

@Service
public class Login {
    public User doLogin(String username,String password, Model model) {
        System.out.println(this.getClass()+"  > Username: " + username + " , Password: " + password);
        UserMapImp umi = SpringBean.getAc().getBean("userMapImp", UserMapImp.class);
        User nowUser = umi.queryUserByUsername(username);
        if (nowUser != null && nowUser.getPassword().equals(password)) {
            model.addAttribute("user", nowUser);
            model.addAttribute("msg","登陆成功");
            return nowUser;
        } else {
            model.addAttribute("msg", "登陆失败，请检查账号密码是否正确，或注册");
            return null;
        }
    }
}
