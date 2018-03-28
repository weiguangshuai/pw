package com.cqupt.project.dao;

import com.cqupt.project.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author weigs
 * @date 2017/11/16 0016
 */
@Repository
public interface UserDao {

    /**
     * 插入用户信息
     *
     * @param user
     */
    int insertUserInfo(User user);

    /**
     * 根据email和password获取用户信息，判断登录信息是否正确
     *
     * @param email
     * @param password
     * @return
     */
    User getUserInfo(@Param("email") String email, @Param("password") String password);

    /**
     * 用户修改信息
     *
     * @param user
     * @return
     */
    int updateUserInfo(User user);

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    User getUserByName(@Param("username") String username);

    /**
     * 根据email查询用户信息
     *
     * @param email
     * @return
     */
    User getUserByEmail(@Param("email") String email);


}

