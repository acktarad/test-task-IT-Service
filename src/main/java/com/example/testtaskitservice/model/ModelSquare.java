package com.example.testtaskitservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "InputSquares")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelSquare {
    {
        type = "MagicSquare";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String type;
    private String data;


    public int[][] getDataArray() {
        int[][] date = new int[3][3];
        String[] temp = this.data.split(",");
        int count = -1;
        for (int i = 0; i < temp.length - 2; i += 3) {
            count++;
            date[count][0] = Integer.parseInt(temp[i]);
            date[count][1] = Integer.parseInt(temp[i + 1]);
            date[count][2] = Integer.parseInt(temp[i + 2]);
        }
        return date;
    }

    public ModelSquare(int[][] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                sb.append(data[i][j]);
                if (i != data.length - 1 | j != data[0].length - 1)
                    sb.append(",");
            }
        }
        setData(sb.toString());
    }

    public void setData(int[][] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                sb.append(data[i][j]);
                if (i != data.length - 1 | j != data[0].length - 1)
                    sb.append(",");
            }
        }
        this.data = sb.toString();
    }

    public void setData(String data) {
        this.data = data;
    }

    public ModelSquare(String data) {
        setData(data);
    }
}
