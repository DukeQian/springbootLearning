package com.example.one;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ProjectConfig projectConfig;

    @Autowired
    private StudentRepository studentRepository;

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

    @GetMapping(value = "/queryStudent")
    public List<Student> queryStudent(){
        Student a = new Student();
        a.setClassId(1);
        a.setName("test");
        a.setSex(1);
        studentRepository.save(a);
        System.out.println(studentRepository.findAll());
        return studentRepository.findAll();
    }
}
