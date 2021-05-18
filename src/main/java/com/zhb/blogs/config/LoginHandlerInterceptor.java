package com.zhb.blogs.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("user")==null){
            if (request.getParameter("lang")==null){
                request.setAttribute("message","没有权限，请先登录");
            }
            request.getRequestDispatcher("/admin").forward(request,response);
            return false;
        }
        return true;
    }
}
