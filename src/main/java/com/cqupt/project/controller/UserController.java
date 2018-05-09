package com.cqupt.project.controller;

import com.cqupt.project.commons.IdentityEnum;
import com.cqupt.project.commons.Result;
import com.cqupt.project.entity.User;
import com.cqupt.project.redis.JedisClient;
import com.cqupt.project.service.ConfirmInfoService;
import com.cqupt.project.service.UserService;
import com.cqupt.project.util.*;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author weigs
 * @date 2017/11/16 0016
 */
@Api(value = "UserController", description = "Hello控制器")
@Controller
@RequestMapping(value = "/user")
@CrossOrigin("*")
public class UserController {
    private static final Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private Producer captchaProducer;

    @Autowired
    private ConfirmInfoService confirmInfoService;

    @Autowired
    private JedisClient jedisClient;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "用户注册", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result register(User user, HttpServletResponse response) {
        user.setCreateTime(new Date());

        /**
         * 1代表普通用户
         * 2代表管理员用户
         */
        user.setAuthority(IdentityEnum.NORMAL.getCode());
        user.setPassword(MD5Util.encodeByMD5(user.getPassword()));
        String userLogin = CookieUtil.setLoginUser(response);
//        CacheUtil.setUserInfo(userLogin, user);
        String userText = FastJsonConvert.convertObjectToJSON(user);
        jedisClient.set(userLogin, userText);
        return userService.saveUserInfo(user);
    }

    /**
     * 发送邮箱验证码
     *
     * @param email
     * @param request
     */
    @RequestMapping(value = "/sendmail", method = RequestMethod.POST)
    public void sendMail(String email, HttpServletRequest request) {
        MailUtil mailUtil = new MailUtil();
        mailUtil.setToAddress(email);
        //随机生成验证码并将验证码保存到session中去
        String capText = captchaProducer.createText();
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        mailUtil.setContent(capText);
        mailUtil.setSubject("注册");
        try {
            userService.sendMail(mailUtil);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断验证码是否正确
     *
     * @param code
     * @param request
     * @return
     */
    @RequestMapping(value = "/judgecode", method = RequestMethod.GET)
    @ResponseBody
    public Result judgeCode(String code, HttpServletRequest request) {
        String capText = (String) request.getSession()
                .getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (!StringUtils.isEmpty(code) && !StringUtils.isEmpty(capText)
                && code.equals(capText)) {
            //清除session中的验证码
            request.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
            return Result.success();
        }
        return Result.error("验证码错误");
    }

    /**
     * 用户登录
     *
     * @param response
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(HttpServletResponse response, User user) {

        Result result = userService.userLogin(user.getEmail(),
                MD5Util.encodeByMD5(user.getPassword()));

        //判断是否登录成功，登录成功就将数据存入cookie和redis缓存中
        if (result.isSuccess()) {
            String userLogin = CookieUtil.setLoginUser(response);
//            CacheUtil.setUserInfo(userLogin, (User) result.getData());
            String userText = FastJsonConvert.convertObjectToJSON(result.getData());
            jedisClient.set(userLogin, userText);
        }
        return result;
    }

    /**
     * 退出登录
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Result logout(HttpServletResponse response, HttpServletRequest request) {
        String userKey = CookieUtil.getCookieValue(request);
        CookieUtil.removeCookie(response);
//        CacheUtil.removeUserInfo(CookieUtil.getCookieValue(request));
        jedisClient.del(userKey);
        return Result.success();
    }

    /**
     * 异步验证email是否注册
     *
     * @param email
     * @return
     */
    @RequestMapping(value = "/mail", method = RequestMethod.POST)
    @ResponseBody
    public Result<User> existMail(String email) {
        return userService.getUser(email);
    }

    /**
     * 判断用户名是否注册过
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/username", method = RequestMethod.POST)
    @ResponseBody
    public Result existUser(String username) {
        return userService.existUser(username);
    }


    /**
     * 查看是否已经提交认证信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/exist/confirm", method = RequestMethod.GET)
    @ResponseBody
    public Result existConfirm(HttpServletRequest request) {
        User user = CacheUtil.getUserInfo(CookieUtil.getCookieValue(request));
        Long userId = user.getUserId();
        return confirmInfoService.getConfirmInfoByUserId(userId);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setCaptchaProducer(Producer captchaProducer) {
        this.captchaProducer = captchaProducer;
    }
}
