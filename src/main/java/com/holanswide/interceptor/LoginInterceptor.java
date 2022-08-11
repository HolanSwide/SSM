package com.holanswide.interceptor;

import com.holanswide.model.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/6/23 23:05
 */

public class LoginInterceptor implements HandlerInterceptor {
    private List<String> exceptUrls;

    public List<String> getExceptUrls() {
        return exceptUrls;
    }

    public void setExceptUrls(List<String> exceptUrls) {
        this.exceptUrls = exceptUrls;
    }


    @Override
    // 判断请求是否放行 True放行 False拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断是否拦截请求
        //在请求处理的方法之前执行
        //如果返回true执行下一个拦截器
        //如果返回false就不执行下一个拦截器
        String requestUri = request.getRequestURI();
        if(requestUri.startsWith(request.getContextPath())){
            requestUri = requestUri.substring(request.getContextPath().length());
        }
        //系统根目录
        if (requestUri.equals("/")) {
            return true;
        }
        //放行exceptUrls中配置的url
        for (String url:exceptUrls) {
            if(url.endsWith("/**")){
                if (requestUri.startsWith(url.substring(0, url.length() - 3))) {
                    return true;
                }
            } else if (requestUri.startsWith(url)) {
                return true;
            }
        }

        System.out.println("Pre... "+handler.toString());
        // handler是url请求访问的控制器（类）
        User user = (User)request.getSession().getAttribute("user");
        if(user == null) {
            response.sendRedirect("http://localhost/");
            return false;
        }
        return true;
    }
}