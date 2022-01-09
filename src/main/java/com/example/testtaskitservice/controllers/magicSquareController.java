package com.example.testtaskitservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Collections;

@Controller
public class magicSquareController {
    @GetMapping("/calculate")
    public String calculate(Model model,
                            @RequestParam("topLeft") String topLeft,
                            @RequestParam("topCenter") String topCenter,
                            @RequestParam("topRight") String topRight,
                            @RequestParam("centerLeft") String centerLeft,
                            @RequestParam("centerCenter") String centerCenter,
                            @RequestParam("centerRight") String centerRight,
                            @RequestParam("bottomLeft") String bottomLeft,
                            @RequestParam("bottomCenter") String bottomCenter,
                            @RequestParam("bottomRight") String bottomRight){
        int[][] inputArray = new int[3][3];
        inputArray[0][0] = Integer.valueOf(topLeft);
        inputArray[0][1] = Integer.valueOf(topCenter);
        inputArray[0][2] = Integer.valueOf(topRight);
        inputArray[1][0] = Integer.valueOf(centerLeft);
        inputArray[1][1] = Integer.valueOf(centerCenter);
        inputArray[1][2] = Integer.valueOf(centerRight);
        inputArray[2][0] = Integer.valueOf(bottomLeft);
        inputArray[2][1] = Integer.valueOf(bottomCenter);
        inputArray[2][2] = Integer.valueOf(bottomRight);
        model.addAllAttributes(Collections.singleton(inputArray));


        return "mainSquare";
    }
}
