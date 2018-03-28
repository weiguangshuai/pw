package com.cqupt.project.commons;

/**
 * @author weigs
 * @date 2018/3/18 0018
 */
public enum ResponseCode {
    SUCCESS(0,"success"),
    ERROR(1,"error"),
    NEED_LOGIN(2,"need login");
    private int code;
    private String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
