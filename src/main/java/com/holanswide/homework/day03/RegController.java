package com.holanswide.homework.day03;

import com.holanswide.factory.SpringBean;
import com.holanswide.service.Register;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/8/3 19:44
 */
@Controller
@RequestMapping("/demo")
public class RegController {
    @GetMapping("/reg")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        return SpringBean.getAc().getBean("registerDemo", RegisterDemo.class).doRegister(username, password, model);
    }
}
