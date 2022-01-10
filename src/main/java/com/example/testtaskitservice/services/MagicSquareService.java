package com.example.testtaskitservice.services;

import com.example.testtaskitservice.model.ModelSquare;
import com.example.testtaskitservice.repository.SquareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MagicSquareService {
    @Autowired
    private SquareRepository squareRepository;

    public int[] twoDimensionalArrayToOne(int[][] matrix) {
        int count = 0;
        int[] tempArray = new int[matrix.length * matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                tempArray[count] = matrix[i][j];
                count++;
            }
        }
        Arrays.sort(tempArray);
        return tempArray;
    }

    public boolean couldBeAMagicSquare(int[][] matrix) {
        int[] tempArray = twoDimensionalArrayToOne(matrix);
        int k;
        if (tempArray[0] != tempArray[tempArray.length - 1] / tempArray.length)
            return false;
        else
            k = tempArray[tempArray.length - 1] / tempArray.length;
        boolean allNonZero = false;
        for (int i = 0; i < tempArray.length; i++) {
            if(tempArray[i]!=0)
                allNonZero = true;
                break;
        }
        if (allNonZero == false)
            return false;
        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i] != i * k + k)
                return false;
        }
        return true;
    }

    public int[][] getRotatedMatrix(int[][] inputArray) {
        int[][] outputArray = new int[inputArray.length][inputArray[0].length];
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[0].length; j++) {
                outputArray[i][j] = inputArray[inputArray[0].length - j - 1][i];
            }
        }
        return outputArray;

    }

    public int[][] getReflectedMatrix(int[][] inputArray) {
        int[][] outputArray = new int[inputArray.length][inputArray[0].length];
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[0].length; j++) {
                outputArray[i][j] = inputArray[i][inputArray[0].length - j - 1];
            }
        }
        return outputArray;
    }

    public int[][] getGeneralMagicSquare(int[][] inputArray) {
        int[][] outputArray = new int[inputArray.length][inputArray[0].length];
        int[] tempArray = twoDimensionalArrayToOne(inputArray);
        int x = inputArray[0].length / 2; //индексы с 0, поэтому без +1
        int y = 0;
        int previous_x = x;
        int previous_y = y;
        for (int i = 0; i < tempArray.length; i++) {
            if (i == 0)
                outputArray[y][x] = tempArray[i];
            else {
                x = x + 1;
                y = y - 1;
                if (y < 0 || x >= outputArray[0].length || y >= outputArray.length) {
                    if (y < 0)
                        y = outputArray.length - 1;
                    if (x >= outputArray[0].length)
                        x = 0;
                    if (y >= outputArray.length)
                        y = 0;
                }
                if (outputArray[y][x] != 0) {
                    x = previous_x;
                    y = previous_y + 1;
                }
                previous_x = x;
                previous_y = y;
                outputArray[y][x] = tempArray[i];
            }
        }
        return outputArray;
    }

    public int[][][] getMagicSquareArray(int[][] inputArray) {
        int[][][] outputArray = new int[8][inputArray.length][inputArray[0].length];
        for (int k = 0; k < outputArray.length - 1; k += 2) {
            if (k == 0) {
                outputArray[k] = getGeneralMagicSquare(inputArray);
                outputArray[k + 1] = getReflectedMatrix(outputArray[k]);
            } else {
                for (int w = 0; w < 2; w++) {
                    outputArray[k + w] = getRotatedMatrix(outputArray[k - 2 + w]);
                }
            }
        }
        return outputArray;
    }

    public int getDifference(int[][] ar1, int[][] ar2) {
        int sum = 0;
        for (int i = 0; i < ar1.length; i++) {
            for (int j = 0; j < ar1[0].length; j++) {
                sum += Math.abs(ar1[i][j] - ar2[i][j]);
            }
        }
        return sum;
    }

    public int[] getDifferenceArray(int[][][] arrayMatrix, int[][] arr) {
        int[] sum = new int[arrayMatrix.length];
        for (int i = 0; i < arrayMatrix.length; i++) {
            sum[i] = getDifference(arrayMatrix[i], arr);
        }
        return sum;
    }

    public int[][] getMagicSquare(int[][] inputArray) {
        if(couldBeAMagicSquare(inputArray)){
            int[][][] tempArrayMatrix = getMagicSquareArray(inputArray);
            int[] difference = getDifferenceArray(tempArrayMatrix, inputArray);
            int indexOfMin = 0;
            for (int i = 1; i < difference.length; i++) {
                if (difference[i] < difference[indexOfMin]) {
                    indexOfMin = i;
                }
            }
            int[][] outputArray = tempArrayMatrix[indexOfMin];
            return outputArray;
        }
        return null;
    }

    public void save(int[][] date){
        ModelSquare modelSquare = new ModelSquare();
        modelSquare.setData(date);
        squareRepository.save(modelSquare);
    }

    public List<ModelSquare> getAllSquare(){
        List<ModelSquare> allSquare = squareRepository.findAll();
        return allSquare;
    }

    public Optional<ModelSquare> findById(Integer id){
        return squareRepository.findById(id);
    }

    public void saveToFile(Integer id){
        ModelSquare modelSquare = findById(id).get();
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter("square"+id.toString()+".txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.format("%s|%s\n",modelSquare.getType(), modelSquare.getData()));
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
