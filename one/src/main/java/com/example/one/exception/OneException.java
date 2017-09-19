package com.example.one.exception;

public class OneException extends RuntimeException{

    private Integer code;

    public OneException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
