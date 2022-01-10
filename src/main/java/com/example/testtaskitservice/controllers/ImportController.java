package com.example.testtaskitservice.controllers;

import com.example.testtaskitservice.model.ModelSquare;
import com.example.testtaskitservice.services.MagicSquareService;
import com.example.testtaskitservice.services.SubStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ImportController {

    @Autowired
    MagicSquareService magicSquareService;
    @Autowired
    SubStringService subStringService;

    @PostMapping("/importFile")
    public String imp(Model model,
                      @RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String tempString = new String(file.getBytes());
            String[] tempStringArray = tempString.replaceAll("\n", "").split("\\|");
            if (tempStringArray[0].equals("MagicSquare")) {
                ModelSquare modelSquare = new ModelSquare();
                modelSquare.setData(tempStringArray[1]);
                int[][] inputArray = modelSquare.getDataArray();
                int[][] outputArray = magicSquareService.getMagicSquare(inputArray);
                model.addAttribute("inputArray", inputArray);
                model.addAttribute("outputArray", outputArray);
                return "resultSquare";
            } else {
                String[] outputArray = subStringService.arrayOfSubstrings(tempStringArray[1].split(","), tempStringArray[2].split(","));
                String[] inputArray = new String[2];
                inputArray[0] = tempStringArray[1];
                inputArray[1] = tempStringArray[2];
                model.addAttribute("inputArray", inputArray);
                model.addAttribute("outputArray", outputArray);
                return "resultSubString";
            }
        }
        return "redirect:/";

    }
}
