package com.cqupt.project.commons;

/**
 * @author weigs
 * @date 2018/4/8 0008
 */
public enum IdentityEnum {
    ADMIN(2),
    NORMAL(1);

    private int code;

    private IdentityEnum(int code) {

        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
