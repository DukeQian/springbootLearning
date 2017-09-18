package com.example.one.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestPageController {

    @GetMapping(value = "index")
    public String toIndex(){
        return "index";
    }
}
