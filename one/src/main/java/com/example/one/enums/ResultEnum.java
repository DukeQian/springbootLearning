package com.example.one.enums;


public enum  ResultEnum {

    UNKNOWN_ERROR(1,"未知错误"),
    SUCCESSOR(2,"成功");

    private Integer code;

    private String message;

    public ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}