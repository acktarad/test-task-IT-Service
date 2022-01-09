package com.example.testtaskitservice.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SubStringService {
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
}