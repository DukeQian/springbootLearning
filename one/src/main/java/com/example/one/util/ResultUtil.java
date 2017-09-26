package com.example.one.util;

import com.example.one.domain.Result;

public class ResultUtil {

    public static Result sucess(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMessage("success");
        result.setData(object);
        return result;
    }

    public static Result sucess(){
        return sucess(null);
    }

    public static Result fail(Integer code, String message){
        Result result = new Result();
        result.setMessage(message);
        result.setCode(code);
        return result;
    }
}
