package com.example.one;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    private ProjectConfig projectConfig;

    @RequestMapping(value="/test1", method = RequestMethod.GET)
    public String say1(){
        return projectConfig.getTwo();
    }

    @GetMapping(value = "/test")
    public String say(){
        return projectConfig.getOne();
    }

    @GetMapping(value = "/test/{id}")
    public String sayId(@PathVariable("id") String id){
        return "id :" + id;
    }

    @GetMapping(value = "/test2")
    public String sayParam(@RequestParam("param") String param){
        return  param;
    }

    @PostMapping(value="/test3")
    public String sayPostParam(@RequestParam(value = "id", required = false, defaultValue = "1") String param){
        return  param;
    }
}
