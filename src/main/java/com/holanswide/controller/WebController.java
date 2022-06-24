package com.holanswide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/6/24 12:37
 */

@Controller
public class WebController {
    @RequestMapping("/")
    public String toIndex(Model model) {
        model.addAttribute("msg","开启补完计划");
        return "index";
    }
}
