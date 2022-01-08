public class main {
    public static void main(String[] args) {
        final int[][] TABLE = {{1,2,3},{4,5,6},{7,8,9}};
        final int[][] TABLE1 = {{2,1,3},{4,5,6},{7,8,9}};


        MagicSquare magicSquare = new MagicSquare();
        magicSquare.couldBeAMagicSquare(TABLE);
        System.out.println(magicSquare.couldBeAMagicSquare(TABLE));

        int[][] generalMatrix = magicSquare.getGeneralMagicSquare(TABLE1);

        int[][][] array = magicSquare.getMagicSquareArray(TABLE1);

        int[] deference = magicSquare.getDifferenceArray(array, TABLE1);

        for (int i = 0; i < deference.length; i++) {
            System.out.println(deference[i]);
        }

        int[][] matrix1 = magicSquare.getMagicSquare(TABLE1);
        System.out.println();
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                System.out.print(matrix1[i][j]);
            }
            System.out.println();
        }
    }
}
