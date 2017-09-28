package com.example.one.enums;


public enum  ResultEnum {

    UNKNOWN_ERROR(1,"未知错误"),
    SUCCESSOR(2,"成功"),

    PRODUCT_NOT_EXIST(10, "商品不存在"),

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
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
