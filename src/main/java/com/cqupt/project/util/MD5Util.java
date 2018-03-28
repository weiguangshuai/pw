package com.cqupt.project.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author weigs
 * @date 2017/11/18 0018
 */
public class MD5Util {

    public static String encodeByMD5(String str) {
        String result = "";

        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder encoder = new BASE64Encoder();
            byte[] bytes = md5.digest(str.getBytes("UTF-8"));
            result = encoder.encode(bytes);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(encodeByMD5("魏广帅"));
    }
}
