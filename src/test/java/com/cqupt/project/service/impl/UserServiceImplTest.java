package com.cqupt.project.service.impl;

import com.cqupt.project.entity.User;
import com.cqupt.project.service.UserService;
import com.cqupt.project.util.MailUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * UserServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: saveUserInfo(User user, int authority)
     */
    @Test
    public void testSaveUserInfo() throws Exception {
        User user = new User();
        user.setPassword("19961014");
        user.setUsername("weigs");
        user.setCreateTime(new Date());
        user.setEmail("cqut@qq.com");

    }

    @Test
    public void testUserLogin() {
    }

    @Test
    public void testSendMail() throws Exception {
        MailUtil mailUtil = new MailUtil();
        mailUtil.setToAddress("2740182109@qq.com");
        mailUtil.setSubject("测试邮箱");
        mailUtil.setContent("测试验证码发送");
        userService.sendMail(mailUtil);
    }


} 
