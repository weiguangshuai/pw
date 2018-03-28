package com.cqupt.project.util;

import com.cqupt.project.commons.Constants;
import com.cqupt.project.entity.User;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

/**
 * @author weigs
 * @date 2017/12/4 0004
 */
public class CacheUtil {
    private static LoadingCache<String, String> cache = CacheBuilder.newBuilder()
            .expireAfterAccess(Constants.DEFALUT_LOGIN_TIME, Constants.DEFALUT_TIMEUNIT).build(
                    new CacheLoader<String, String>() {
                        @Override
                        public String load(String key) throws Exception {
                            return "null";
                        }
                    }

            );


    /**
     * 获取用户信息
     *
     * @param key
     * @return
     */
    public static User getUserInfo(String key) {
        String userInfo = getKey(key);
        Gson gson = new Gson();
        User user = gson.fromJson(userInfo, User.class);
        if (user != null) {
            return user;
        }
        return null;
    }

    /**
     * 设置用户信息
     *
     * @param key
     * @param user
     */
    public static void setUserInfo(String key, User user) {
        Gson gson = new Gson();
        String userInfo = gson.toJson(user);
        setKey(key, userInfo);
    }

    /**
     * 清除缓存
     *
     * @param key
     */
    public static void removeUserInfo(String key) {
        cache.invalidate(key);
    }

    private static String getKey(String key) {
        String value = null;
        try {
            value = cache.get(key);
            if ("null".equals(value)) {
                return null;
            }
            return value;
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void setKey(String key, String value) {
        cache.put(key, value);
    }
}
