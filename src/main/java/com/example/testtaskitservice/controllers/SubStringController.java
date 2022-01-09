package com.example.testtaskitservice.controllers;

import com.example.testtaskitservice.services.SubStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubStringController {
    @Autowired
    private SubStringService subStringService;

    @PostMapping("/calculateSubString")
    public String calcSubString(Model model,
                                @RequestParam("substrings") String substring,
                                @RequestParam("strings") String string){
        String[] a1 = substring.split(",");
        String[] a2 = string.split(",");
        System.out.println(substring);
        System.out.println(string);
        for (int i = 0; i < a1.length; i++) {
            a1[i] = a1[i].trim();
        }
        for (int i = 0; i < a2.length; i++) {
            a2[i] = a2[i].trim();
        }
        String[] outputArray = subStringService.arrayOfSubstrings(a1,a2);
        for (int i = 0; i < a1.length; i++) {
            System.out.println(a1[i]);
        }
        String[] inputArray = new String[2];
        inputArray[0] = substring;
        inputArray[1] = string;
        model.addAttribute("inputArray", inputArray);
        model.addAttribute("outputArray", outputArray);
        return "resultSubString";
    }
}
