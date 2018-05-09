package com.cqupt.project.util;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * ━━━━━━oooo━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃stay hungry stay foolish
 * 　　　　┃　　　┃Code is far away from bug with the animal protecting
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 *
 * @author weigs
 * @date 2018/4/21 0021
 */
public class FastJsonConvert {

    /**
     * JSON字符串转化为实体对象
     *
     * @param data
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T converJSONToObject(String data, Class<T> clazz) {
        try {
            T t = JSON.parseObject(data, clazz);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将JSON字符串转化为实体集合
     *
     * @param data
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> convertJSONToArray(String data, Class<T> clazz) {
        try {
            List<T> t = JSON.parseArray(data, clazz);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 对象转化为JSON字符串
     *
     * @param o
     * @return
     */
    public static String convertObjectToJSON(Object o) {
        try {
            String text = JSON.toJSONString(o);
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
