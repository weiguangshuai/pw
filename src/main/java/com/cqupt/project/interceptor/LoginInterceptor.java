package com.cqupt.project.interceptor;

import com.cqupt.project.entity.User;
import com.cqupt.project.redis.JedisClient;
import com.cqupt.project.util.CookieUtil;
import com.cqupt.project.util.FastJsonConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author weigs
 * @date 2017/11/22 0022
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private JedisClient jedisClient;

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
//        User user = CacheUtil.getUserInfo(CookieUtil.getCookieValue(request));
        String text = jedisClient.get(CookieUtil.getCookieValue(request));
        User user = FastJsonConvert.converJSONToObject(text, User.class);
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
