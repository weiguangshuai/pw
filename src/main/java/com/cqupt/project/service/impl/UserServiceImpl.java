package com.cqupt.project.service.impl;

import com.cqupt.project.commons.Result;
import com.cqupt.project.dao.UserDao;
import com.cqupt.project.entity.User;
import com.cqupt.project.service.UserService;
import com.cqupt.project.util.CookieUtil;
import com.cqupt.project.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @author weigs
 * @date 2017/11/16 0016
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MimeMessage mimeMessage;

    /**
     * 保存用户数据,用户注册
     *
     * @param user
     */
    @Override
    public Result saveUserInfo(User user) {
        int result = userDao.insertUserInfo(user);
        if (result > 0)
            return Result.success();
        return Result.error("注册失败，请重试");
    }

    /**
     * 用户登录判断
     *
     * @param email
     * @param password
     * @return
     */
    @Override
    public Result<User> userLogin(String email, String password) {
        User user = userDao.getUserInfo(email, password);
        if (user != null) {
            
            return Result.success(user);
        }
        return Result.error("登录失败");
    }

    @Override
    public Result updateUserInfo(User user) {
        int result = userDao.updateUserInfo(user);
        if (result > 0) {
            return Result.success();
        }
        return Result.error("修改失败，请重试");
    }

    @Override
    public Result existUser(String username) {
        User user = userDao.getUserByName(username);
        if (user == null) {
            return Result.success();
        }
        return Result.error("用户已经存在");
    }


    @Override
    public Result<User> getUser(String email) {
        User user = userDao.getUserByEmail(email);
        if (user == null) {
            return Result.success();
    }
        return Result.error("邮箱已被注册");
    }

    @Override
    public void sendMail(MailUtil mailUtil) throws MessagingException {

        MimeMessageHelper mailMessage = new MimeMessageHelper(mimeMessage,
                true, "UTF-8");
        mailMessage.setFrom(mailUtil.getFromAddress());
        mailMessage.setSubject(mailUtil.getSubject());
        //支持html
        mailMessage.setText(mailUtil.getContent(), true);
        mailMessage.setSentDate(new Date());
        mailMessage.setTo(mailUtil.getToAddress());
        javaMailSender.send(mimeMessage);
    }

    @Override
    public Result<User> getUserByName(String username) {
        User user = userDao.getUserByName(username);
        if (user != null) {
            return Result.success(user);
        }
        return Result.error("用户不存在，请注册");
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
