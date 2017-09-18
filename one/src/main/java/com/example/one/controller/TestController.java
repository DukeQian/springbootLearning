package com.example.one.controller;


import com.example.one.properties.ProjectConfig;
import com.example.one.domain.Student;
import com.example.one.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

    @GetMapping(value = "/students")
    public List<Student> queryStudent(){
        return studentRepository.findAll();
    }

    @PostMapping(value = "/students")
    public Student updateStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping(value = "/students/{id}")
    public Student queryOneStudent(@PathVariable int id){
        return studentRepository.findOne(id);
    }

    @GetMapping(value = "/students/name")
    public Student queryOneStudentByName( @RequestParam String name){
        Student a = new Student();
        a.setName(name);
        Example<Student> ex= Example.of(a);
        return  studentRepository.findAll(ex).get(0);
    }

    @PutMapping(value = "/students/{id}")
    public Student updateOneStudent(@PathVariable int id, @RequestParam String name){
        Student a = new Student();
        a.setId(id);
        a.setName(name);
        return studentRepository.save(a);
    }
}
