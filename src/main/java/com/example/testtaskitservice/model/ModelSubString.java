package com.example.testtaskitservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "InputSubstring")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelSubString {
    {
        type = "SubString";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String type;
    private String substrings;
    private String strings;

    public String[] getSubstrings() {
        String[] outputString = this.substrings.split(",");
        return outputString;
    }

    public String[] getStrings() {
        String[] outputString = this.strings.split(",");
        return outputString;
    }

    public ModelSubString(String substrings, String strings){
        setStrings(strings);
        setSubstrings(substrings);

    }
    public ModelSubString(String[] substrings, String[] strings){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < substrings.length; i++) {
            sb.append(substrings[i]);
            if (i != substrings.length-1) {
                sb.append(",");
            }
        }
        setStrings(sb.toString());
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
            if (i != strings.length-1) {
                sb1.append(",");
            }
        }
        setSubstrings(sb1.toString());
    }
}
