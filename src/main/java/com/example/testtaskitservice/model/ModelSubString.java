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
    private String substring;
    private String string;

    public String[] getSubstrings() {
        return this.substring.split(",");
    }

    public String[] getStrings() {
        return this.string.split(",");
    }

    public ModelSubString(String substrings, String strings) {
        setString(strings);
        setSubstring(substrings);

    }

    public ModelSubString(String[] substrings, String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < substrings.length; i++) {
            sb.append(substrings[i]);
            if (i != substrings.length - 1) {
                sb.append(",");
            }
        }
        setSubstring(sb.toString());
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb1.append(strings[i]);
            if (i != strings.length - 1) {
                sb1.append(",");
            }
        }
        setString(sb1.toString());

    }
}
