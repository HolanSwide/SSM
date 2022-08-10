package com.holanswide.service;

import com.holanswide.factory.SpringBean;
import com.holanswide.mapper.UserMapImp;
import com.holanswide.model.User;
import com.holanswide.model.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/8/3 10:57
 */

@Service
public class Register {
    public String doRegister(String username, String password, UserInfo userInfo, Model model) {
        System.out.println(this.getClass() + " >Register - Username:" + username + " Password:" + password);
        User user = (User) SpringBean.getAc().getBean("user", User.class);
        user.setUsername(username);
        user.setPassword(password);
        UserMapImp umi = SpringBean.getAc().getBean("userMapImp", UserMapImp.class);
        int res = umi.addUser(user);
        if (res == 1) {
            res = umi.addUserInfo(userInfo);
        }
        String msg = null;
        switch (res) {
            case 1:
                msg = "注册成功！点击确认自动登录";
                break;
            case 2:
                msg = "用户名重复！";
                break;
            case 4:
                msg = "手机号已被注册！";
                break;
            case 5:
                msg="邮箱已被注册！";
                break;
            default:
                msg = "注册失败，请重试...";
                break;
        }
        model.addAttribute("msg", msg);
        model.addAttribute("res", res);
        return "index";
    }
}
