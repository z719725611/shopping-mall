package com.zqb.common;

import java.io.Serializable;

/**
 * rest接口返回数据模型
 *
 * @param <T> 数据对象类型
 * @author liaojh
 */
public class ReturnObject<T> implements Serializable {
    private static final long serialVersionUID = -6660411233872041901L;
    private boolean success;
    private String message;
    private T data;

    public ReturnObject() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ReturnObject<T> success(T data) {
        ReturnObject<T> returnObject = new ReturnObject<>();
        returnObject.data = data;
        returnObject.success = true;
        return returnObject;
    }

    public static <T> ReturnObject<T> fail(T data, String message) {
        ReturnObject<T> returnObject = new ReturnObject<>();
        returnObject.data = data;
        returnObject.message = message;
        returnObject.success = false;
        return returnObject;
    }
}