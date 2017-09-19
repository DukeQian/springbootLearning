package com.example.one.handle;


import com.example.one.domain.Result;
import com.example.one.exception.OneException;
import com.example.one.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandle.class);

    @ExceptionHandler
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof OneException){
            OneException oneException = (OneException) e;
            return ResultUtil.fail(oneException.getCode(),oneException.getMessage());
        }
        logger.error("exception={}", e);
        return ResultUtil.fail(100, e.getMessage());
    }
}
