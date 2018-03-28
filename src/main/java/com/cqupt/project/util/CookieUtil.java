package com.cqupt.project.util;

import com.cqupt.project.commons.Constants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.UUID;

/**
 * @author weigs
 * @date 2017/11/17 0017
 */
public class CookieUtil {


    /**
     * 设置登录状态信息到cookie中
     *
     * @param response
     */
    public static String setLoginUser(HttpServletResponse response) {
        if (response == null)
            return null;
        /**
         long userId = user.getUserId();
         String username = user.getUsername();
         int authority = user.getAuthority();
         //防止中文乱码，进行base64编码用户名
         BASE64Encoder encoder = new BASE64Encoder();
         try {
         username = encoder.encode(username.getBytes("UTF-8"));
         } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
         }
         StringBuilder cookieValue = new StringBuilder();
         cookieValue.append(username).append("|").append(authority).append("|")
         .append(MD5Util.encodeByMD5(user.getUsername()));

         **/
        String value = UUID.randomUUID().toString();
        addCookie(response, Constants.USER_INFO, value);
        return value;
    }

    /**
     * 添加cookie
     *
     * @param response
     * @param name
     * @param value
     */
    private static void addCookie(HttpServletResponse response,
                                  String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 获取用户信息
     *
     * @param request
     * @return
     */
    /**
     public static User getLoginUser(HttpServletRequest request) {

     User user = new User();
     String value = getCookieValue(Constants.USER_INFO, request);
     if (StringUtils.isEmpty(value)) {
     return null;
     }
     String[] strs = value.split("\\|");
     //对用户名进行解码
     BASE64Decoder decoder = new BASE64Decoder();
     byte[] bytes = new byte[0];
     try {
     bytes = decoder.decodeBuffer(strs[0]);
     } catch (IOException e) {
     e.printStackTrace();
     }
     //判断正确代表不是伪造cookie，可以直接获取cookie中的用户信息
     if (MD5Util.encodeByMD5(new String(bytes)).equals(strs[2])) {
     user.setUsername(new String(bytes));
     user.setAuthority(Integer.parseInt(strs[1]));
     return user;
     }
     return null;
     }
     **/
    /**
     * 获取cookie的值
     *
     * @param request
     * @return
     */
    public static String getCookieValue(HttpServletRequest request) {
        if (null == request) {
            return null;
        }
        Cookie[] cookies = request.getCookies();
        if (cookies == null || 0 == cookies.length) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (Objects.equals(cookie.getName(), Constants.USER_INFO)) {
                return cookie.getValue();
            }
        }

        return null;
    }

    /**
     * 删除cookie
     *
     * @param response
     * @param name
     */
    public static void removeCookie(HttpServletResponse response) {
        if (null == response) {
            return;
        }
        Cookie cookie = new Cookie(Constants.USER_INFO, "");
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
