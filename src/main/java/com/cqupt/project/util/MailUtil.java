package com.cqupt.project.util;

/**
 * @author weigs
 * @date 2017/11/20 0020
 */
public class MailUtil {
    private static final String FROM_ADDRESS = "cqupt_wgs@163.com";

    //发件人地址
    private String fromAddress = FROM_ADDRESS;
    //收件人地址
    private String toAddress;

    //邮箱主题
    private String subject;

    //邮箱内容
    private String content;


    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
