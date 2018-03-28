package com.cqupt.project.interceptor;

import com.cqupt.project.entity.User;
import com.cqupt.project.util.CacheUtil;
import com.cqupt.project.util.CookieUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author weigs
 * @date 2017/11/22 0022
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 用户登录拦截器
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = CacheUtil.getUserInfo(CookieUtil.getCookieValue(request));
        if (null != user) {
            return true;
        }
        response.sendRedirect("/login.jsp");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
