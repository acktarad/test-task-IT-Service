package com.example.testtaskitservice.services;

import com.example.testtaskitservice.model.ModelSquare;
import com.example.testtaskitservice.model.ModelSubString;
import com.example.testtaskitservice.repository.Substringrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubStringService {

    @Autowired
    Substringrepository substringrepository;

    /***
     * Принимает на вход массивы подстрок и строк
     * проверяет вхождение подстрок (содержет ли строка
     * подстроку) в строки
     * @param subStrings - массив подстрок
     * @param strings
     * @return
     */
    public String[] arrayOfSubstrings(String[] subStrings, String[] strings) {
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

    public void save(String substring, String string) {
        ModelSubString modelSubString = new ModelSubString(substring, string);
        substringrepository.save(modelSubString);
    }

    public void save(String[] substrings, String[] strings) {
        ModelSubString modelSubString = new ModelSubString(substrings, strings);
        substringrepository.save(modelSubString);
    }

    public List<ModelSubString> getAllSubstringTask() {
        List<ModelSubString> allSubString = substringrepository.findAll();
        return allSubString;
    }

    public Optional<ModelSubString> findById(Integer id) {
        return substringrepository.findById(id);
    }

    /***
     * Приниает на вход id элемента
     * сохраняет в файл тип задачи и
     * данные для её повторного решения
     * @param id - идентификатор задачи в БД
     */
    public void saveToFile(Integer id) {

        ModelSubString modelSubString = findById(id).get();
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter("substring" + id.toString() + ".txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.format("%s|%s|%s\n", modelSubString.getType(), modelSubString.getSubstring(), modelSubString.getString()));
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("Ошибка" + e.getMessage());
        } finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException ignore) {
            }
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException ignore) {
            }
        }
    }
}
