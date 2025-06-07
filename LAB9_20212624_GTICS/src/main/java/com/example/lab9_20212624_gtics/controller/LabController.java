package com.example.lab9_20212624_gtics.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LabController {


    //agregaremos los endpoints necesarios para el lab9
    //endpoint testintg

    @GetMapping("/testing")
    public String testing() {
        return "testing";
    }
}
