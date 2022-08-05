package com.holanswide.homework.day03;

import com.holanswide.factory.SpringBean;
import com.holanswide.mapper.UserMapImp;
import com.holanswide.model.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/8/3 19:42
 */
@Service
public class RegisterDemo {
    public String doRegister(String username, String password, Model model) {
        System.out.println(this.getClass()+" >Register - Username:"+username+" Password:"+password);
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
