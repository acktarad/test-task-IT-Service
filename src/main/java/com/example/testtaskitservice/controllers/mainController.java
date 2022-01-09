package com.example.testtaskitservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class mainController {

    @GetMapping("/")
    public String main(){
        return "mainSquare";
    }
    @PostMapping("/taskSelection")
    public String taskSelection(@RequestParam("combobox") String combobox){
        if(combobox.equals("magicSquare"))
            return "mainSquare";
        else
            return "mainSubString";
    }
}
