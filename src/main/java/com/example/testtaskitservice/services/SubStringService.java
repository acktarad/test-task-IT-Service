package com.example.testtaskitservice.services;

import com.example.testtaskitservice.model.ModelSubString;
import com.example.testtaskitservice.repository.Substringrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubStringService {

    @Autowired
    Substringrepository substringrepository;
    public String[] arrayOfSubstrings(String[] subStrings, String[] strings) {
        //        String[] a1 = {"arp", "live", "strong"};
//        String[] a2 = {"lively", "alive", "harp", "sharp", "armstrong"};
//        String[] a3 = {"tarp", "mice", "bull"};
        List<String> outputList = new ArrayList<>();
        for (int i = 0; i < subStrings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (strings[j].contains(subStrings[i])) {
                    outputList.add(subStrings[i]);
                    break;
                }
            }
        }
        String[] outputArray = new String[outputList.size()];
        return outputList.toArray(outputArray);
    }

    public void save(String substring, String string){
        ModelSubString modelSubString = new ModelSubString(substring, string);
        substringrepository.save(modelSubString);
    }

    public void save(String[] substrings, String[] strings){

        ModelSubString modelSubString = new ModelSubString(substrings,strings);
        substringrepository.save(modelSubString);
    }

    public List<ModelSubString> getAllSubstringTask(){
        List<ModelSubString> allSubString = substringrepository.findAll();
        return allSubString;
    }

    public Optional<ModelSubString> findById(Integer id){
        return substringrepository.findById(id);
    }
}
