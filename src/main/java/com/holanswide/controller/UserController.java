package com.holanswide.controller;

import com.alibaba.fastjson.JSON;
import com.holanswide.mapper.UserMap;
import com.holanswide.mapper.UserMapImp;
import com.holanswide.model.AllInfo;
import com.holanswide.model.Rights;
import com.holanswide.utils.SpringBean;
import com.holanswide.model.User;
import com.holanswide.model.UserInfo;
import com.holanswide.service.Login;
import com.holanswide.service.Register;
import com.holanswide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/8/4 0:00
 */

@Controller
@RequestMapping(value = "/user", produces = {"application/json;charset=UTF-8"})
public class UserController {
    @GetMapping("/uptype")
    public @ResponseBody
    String changeType(@RequestParam("type") int type, @RequestParam("uid") int uid) {
        SpringBean.getAc().getBean("userMapImp", UserMapImp.class).updateRights(type, uid);
        return "修改成功";
    }

    @GetMapping(value = "/del",produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    String delUser(@RequestParam("uid") int uid) {
        SpringBean.getAc().getBean("userMapImp", UserMapImp.class).delUserByUid(uid);
        SpringBean.getAc().getBean("userMapImp", UserMapImp.class).delUserInfoByUid(uid);
        return "删除成功";
    }

    @GetMapping(value = "/all",produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    String getAll() {
        return JSON.toJSONString(
                SpringBean.getAc().getBean("userMapImp", UserMapImp.class).queryAllInfo()
        );
    }

    @GetMapping("/type")
    public @ResponseBody
    String getType(@RequestParam(name = "uid",required = true) int uid) {
        return JSON.toJSONString(
                SpringBean.getAc().getBean("userMapImp", UserMapImp.class).queryRightByUid(uid)
        );
    }

    @GetMapping("/myinfo")
    public @ResponseBody
    String getMyInfo(HttpServletRequest request) {
        User me = (User) request.getSession().getAttribute("user");
        System.out.println(this.getClass()+" > "+me);
        return JSON.toJSONString(
                SpringBean.getAc().getBean("userMapImp", UserMapImp.class).queryUserInfoByUid(me.getUid())
        );
    }

    @GetMapping("/exit")
    public String toExit(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }

    @PostMapping("/info")
    public @ResponseBody
    String getUserInfo(@RequestBody String obj, HttpServletRequest request, Model model) {
        String type = JSON.parseObject(obj).getString("type");
        String param= JSON.parseObject(obj).getString("param");
        int pageSize = JSON.parseObject(obj).getIntValue("pageSize");
        int pageBegin = JSON.parseObject(obj).getIntValue("pageBegin");
        System.out.println(this.getClass()+" > "+type+" "+param+" "+pageBegin+" "+pageSize);
        pageBegin = (pageBegin-1)*pageSize;
        return JSON.toJSONString(
                SpringBean.getAc().getBean("userService", UserService.class).getUsers(type,param,pageSize,pageBegin)
        );
    }

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
        User user = JSON.parseObject(obj).getObject("user",User.class);
        UserInfo userInfo = JSON.parseObject(obj).getObject("userInfo",UserInfo.class);
        String username = user.getUsername() ;
        String password = user.getPassword() ;
        System.out.println(">UserInfo:"+userInfo);
        SpringBean.getAc().getBean("register", Register.class).doRegister(username, password, userInfo, model);
        return JSON.toJSONString(new RegisterSendBody((String)model.getAttribute("msg"), (Integer) model.getAttribute("res")));
    }

    @PostMapping("/repass.do")
    public @ResponseBody
    String repass(@RequestBody String obj) {
        String phone = JSON.parseObject(obj).getString("phone");
        String password = JSON.parseObject(obj).getString("password");
        int res =
                SpringBean.getAc().getBean("userService",UserService.class).changePwd(phone,password);
        String msg = "修改成功！";
        if(res==0) msg = "未找到该手机号，请检查输入或注册";
        return JSON.toJSONString(new RepassSendBody(res,msg));
    }
}

@Component
class LoginSendBody {
    @Autowired
    public User user;
    @Value("出现意外错误")
    public String msg;
    @Value("http://localhost/")
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
        this.url = "http://localhost/";
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

class RepassSendBody {
    int res;
    String msg;

    public RepassSendBody(int res, String msg) {
        this.res = res;
        this.msg = msg;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
