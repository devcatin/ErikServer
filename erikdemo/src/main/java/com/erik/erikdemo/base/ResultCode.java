package com.erik.erikdemo.base;

import java.io.Serializable;

public enum ResultCode implements Serializable {

    // 自定义状态码
    SUCCESS(200, "请求成功"),

    FAILURE(-1, "请求失败");

    private int code;

    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static int getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return 0;
    }

}
