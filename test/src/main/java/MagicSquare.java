import java.util.Arrays;

public class MagicSquare {

    public int[] twoDimensionalArrayToOne(int[][] matrix){
        int count = 0;
        int[] tempArray = new int[matrix.length * matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                tempArray[count] = matrix[i][j];
                count++;
            }
        }
        return tempArray;
    }

    public boolean couldBeAMagicSquare(int[][] matrix) {
        int[] tempArray = twoDimensionalArrayToOne(matrix);

        Arrays.sort(tempArray);
        int k;
        if (tempArray[0] != tempArray[tempArray.length - 1] / tempArray.length)
            return false;
        else
            k = tempArray[tempArray.length - 1] / tempArray.length;
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
            if(i == 0)
                outputArray[y][x] = tempArray[i];
            else{
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
                if(outputArray[y][x]!=0){
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
}
