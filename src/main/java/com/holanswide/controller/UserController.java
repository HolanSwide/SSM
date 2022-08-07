package com.holanswide.controller;

import com.alibaba.fastjson.JSON;
import com.holanswide.factory.SpringBean;
import com.holanswide.mapper.UserMapImp;
import com.holanswide.model.User;
import com.holanswide.service.Login;
import com.holanswide.service.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/6/24 0:00
 */

@Controller
@RequestMapping(value = "/user", produces = {"application/json;charset=UTF-8"})
public class UserController {
    @GetMapping("/me")
    public @ResponseBody
    String getMe(HttpServletRequest request) {
        String res = JSON.toJSONString(
                (User) request.getSession().getAttribute("user")
        );
        System.out.println(this.getClass() + " " + res);
        return res;
    }

    @PostMapping("/login")
    public @ResponseBody
    String login(@RequestBody String obj, HttpServletRequest request, Model model) {
        System.out.println(obj);
        String username = JSON.parseObject(obj).getString("username");
        String password = JSON.parseObject(obj).getString("password");
        User user = SpringBean.getAc().getBean("login", Login.class).doLogin(username, password, model);
        request.getSession().setAttribute("user", user);
        System.out.println(">user:" + user);
        boolean sign = false;
        if (user != null) {
            sign = true;
            user.setPassword("******");
        }
        return JSON.toJSONString(
                new LoginSendBody(user, (String) model.getAttribute("msg"), sign)
        );
    }

    @PostMapping("/register")
    public @ResponseBody
    String register(@RequestBody String obj, Model model) {
        String username = JSON.parseObject(obj).getString("username");
        String password = JSON.parseObject(obj).getString("password");
        SpringBean.getAc().getBean("register", Register.class).doRegister(username, password, model);
        return JSON.toJSONString(new RegisterSendBody((String)model.getAttribute("msg"),(int)model.getAttribute("res")));
    }
}

@Component
class LoginSendBody {
    @Autowired
    public User user;
    @Value("出现意外错误")
    public String msg;
    @Value("http://localhost:8080/SSM_war_exploded/")
    public String url;
    @Value("true")
    public boolean sign;

    @Override
    public String toString() {
        return "loginSendBody:{" + this.user + " " + this.msg + "}";
    }

    public LoginSendBody() {
    }

    public LoginSendBody(User user, String msg, boolean sign) {
        this.user = user;
        this.msg = msg;
        this.url = "http://localhost:8080/SSM_war_exploded/";
        this.sign = sign;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}


class RegisterSendBody {
    String msg;
    int res;

    public RegisterSendBody(String msg, int res) {
        this.msg = msg;
        this.res = res;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
