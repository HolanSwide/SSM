package com.holanswide.service;

import com.holanswide.model.Rights;
import com.holanswide.utils.SpringBean;
import com.holanswide.mapper.UserMapImp;
import com.holanswide.model.User;
import com.holanswide.model.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.UUID;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/8/3 10:57
 */

@Service
public class Register {
    public void doRegister(String username, String password, UserInfo userInfo, Model model) {
        System.out.println(this.getClass() + " >Register - Username:" + username + " Password:" + password);
        User user = (User) SpringBean.getAc().getBean("user", User.class);
        user.setUsername(username);
        user.setPassword(password);
        UserMapImp umi = SpringBean.getAc().getBean("userMapImp", UserMapImp.class);
        int res = umi.addUser(user);
        if (res == 1) {
            user = umi.queryUserByUsername(username);
            userInfo.setUid(user.getUid());
            res = umi.addUserInfo(userInfo);
        }
        String msg = null;
        switch (res) {
            case 1:
                msg = "注册成功！点击确认自动登录";
                umi.addRights(new Rights(user.getUid(), UUID.randomUUID().toString(),3));
                break;
            case 2:
                msg = "用户名重复！";
                umi.delUserByUid(user.getUid());
                break;
            case 4:
                msg = "手机号已被注册！";
                umi.delUserByUid(user.getUid());
                break;
            case 5:
                msg="邮箱已被注册！";
                umi.delUserByUid(user.getUid());
                break;
            default:
                msg = "注册失败，请重试...";
                umi.delUserByUid(user.getUid());
                break;
        }
        model.addAttribute("msg", msg);
        model.addAttribute("res", res);
    }
}
