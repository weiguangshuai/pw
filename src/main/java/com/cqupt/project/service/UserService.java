package com.cqupt.project.service;

import com.cqupt.project.commons.Result;
import com.cqupt.project.entity.User;
import com.cqupt.project.util.MailUtil;

/**
 * @author weigs
 * @date 2017/11/16 0016
 */
public interface UserService {
    /**
     * 保存用户信息
     *
     * @param user
     */
    Result saveUserInfo(User user);

    /**
     * 用户登录
     *
     * @param email
     * @param password
     * @return
     */
    Result<User> userLogin(String email, String password);

    /**
     * 用户修改相关信息
     *
     * @param user
     * @return
     */
    Result updateUserInfo(User user);

    /**
     * 根据用户名判断用户名是否存在
     *
     * @param username
     * @return
     */
    Result existUser(String username);

    /**
     * 根据email判断email是否存在
     *
     * @param email
     * @return
     */
    Result<User> getUser(String email);

    /**
     * 发送邮箱
     *
     * @param mailUtil
     */
    void sendMail(MailUtil mailUtil) throws Exception;

    /**
     * 通过用户名获取用户信息
     *
     * @param username
     * @return
     */
    Result<User> getUserByName(String username);
}
