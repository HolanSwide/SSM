package com.holanswide.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/6/23 23:05
 */

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    // 判断请求是否放行 True放行 False拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断是否拦截请求
        //在请求处理的方法之前执行
        //如果返回true执行下一个拦截器
        //如果返回false就不执行下一个拦截器
        System.out.println("Pre... "+handler.toString());
        // handler是url请求访问的控制器（类）
        return true;
    }

    @Override
    // 请求通过后的操作
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // handler是url请求访问的控制器（类）
        // ModelAndView 包含 Model 和 View 两个属性
        // Model : JSON格式，即发请求的控制器发来的 Model
        // View : 该控制器请求访问的地址
        System.out.println("Post... " + modelAndView.toString());
    }

    @Override
    // 请求放行后，一般用于清理数据
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // handler : 请求来源的控制器
        System.out.println("After... "+handler.toString());
    }
}