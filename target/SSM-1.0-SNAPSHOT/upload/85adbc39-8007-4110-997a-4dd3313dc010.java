package com.holanswide.controller;

import com.holanswide.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/6/24 12:37
 */

@Controller
@SessionAttributes("msg")
public class WebController {
    @RequestMapping("/")
    public String toIndex(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(this.getClass()+" > Session:"+user);
        if(user==null) {
            return "index";
        } else {
            return "hello";
        }

    }

}
