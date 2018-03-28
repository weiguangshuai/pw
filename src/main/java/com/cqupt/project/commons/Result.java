package com.cqupt.project.commons;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 返回结果封装类
 *
 * @author weigs
 * @date 2018/3/18 0018
 */
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    private Result(int code) {
        this.code = code;
    }

    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result(int code, T data) {
        this.code = code;
        this.data = data;
    }


    public static <T> Result<T> success(String msg, T data) {
        return new Result<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> Result<T> success() {
        return new Result<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> Result<T> error(String msg) {
        return new Result<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> error() {
        return new Result<T>(ResponseCode.ERROR.getCode());
    }

    @JsonIgnore
    public boolean isSuccess() {
        return code == ResponseCode.SUCCESS.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
