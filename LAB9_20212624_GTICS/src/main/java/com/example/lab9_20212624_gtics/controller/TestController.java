package com.example.lab9_20212624_gtics.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
