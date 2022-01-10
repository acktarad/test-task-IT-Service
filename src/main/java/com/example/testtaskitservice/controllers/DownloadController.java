package com.example.testtaskitservice.controllers;

import com.example.testtaskitservice.model.ModelSquare;
import com.example.testtaskitservice.model.ModelSubString;
import com.example.testtaskitservice.services.MagicSquareService;
import com.example.testtaskitservice.services.SubStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Controller
public class DownloadController {

    @Autowired
    private MagicSquareService magicSquareService;
    @Autowired
    private SubStringService subStringService;

    @PostMapping("/download")
    public String downloadSquare(Model model){
        List<ModelSquare> modelSquareList = magicSquareService.getAllSquare();
        List<ModelSubString> subStringsList = subStringService.getAllSubstringTask();
        model.addAttribute("SquareList", modelSquareList);
        model.addAttribute("subStringsList", subStringsList);
        return "download";
    }

    @PostMapping("/downloadFilter")
    public String downloadFilter(Model model, @RequestParam("combobox") String combobox) {
        if (combobox.equals("magicSquare")){
            List<ModelSquare> modelSquareList = magicSquareService.getAllSquare();
            model.addAttribute("SquareList", modelSquareList);
            for (int i = 0; i < modelSquareList.size(); i++) {
                System.out.println(modelSquareList.get(i));
            }
            return "download";
        }
        else{
            List<ModelSubString> subStringsList = subStringService.getAllSubstringTask();
            model.addAttribute("subStringsList", subStringsList);
        }
        return "download";
    }

    @PostMapping("/downloadSubstring")
    public String downloadSubstring(Model model,@RequestParam("subStringId") Integer id){
        ModelSubString subString = subStringService.findById(id).get();
        String[] outputArray = subStringService.arrayOfSubstrings(subString.getSubstrings(),subString.getStrings());

        String[] inputArray = new String[2];
        inputArray[0] = subString.getSubstring();
        inputArray[1] = subString.getString();
        model.addAttribute("inputArray", inputArray);
        model.addAttribute("outputArray", outputArray);
        return "resultSubString";
    }

    @PostMapping("/downloadSquare")
    public String downloadSquare(Model model, @RequestParam("squareId") Integer id){
        ModelSquare modelSquare = magicSquareService.findById(id).get();
        int[][] inputArray = modelSquare.getDataArray();
        int[][] outputArray = magicSquareService.getMagicSquare(inputArray);
        model.addAttribute("inputArray", inputArray);
        model.addAttribute("outputArray", outputArray);
        return "resultSquare";
    }
}
