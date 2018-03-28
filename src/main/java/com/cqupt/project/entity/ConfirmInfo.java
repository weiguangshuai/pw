package com.cqupt.project.entity;

/**
 * 认证信息表
 *
 * @author weigs
 * @date 2018/3/18 0018
 */
public class ConfirmInfo {
    private int confirmId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private int userId;

    public int getConfirmId() {
        return confirmId;
    }

    public void setConfirmId(int confirmId) {
        this.confirmId = confirmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ConfirmInfo{" +
                "confirmId=" + confirmId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", userId=" + userId +
                '}';
    }
}
