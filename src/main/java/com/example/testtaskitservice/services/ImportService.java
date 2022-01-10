package com.example.testtaskitservice.services;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class ImportService {

    public String[] readFile(String filename) {
        FileReader reader = null;
        BufferedReader Breader = null;
        String[] data = new String[3];
        try {
            reader = new FileReader(filename);
            Breader = new BufferedReader(reader);
            String string = Breader.readLine();

            while (string != null) {
                data = string.split("\\|");
                string = Breader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка" + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignore) {
                }
            }
            if (Breader != null) {
                try {
                    Breader.close();
                } catch (IOException ignore) {
                }
            }
        }
        return data;
    }

}
