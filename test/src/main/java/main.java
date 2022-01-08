public class main {
    public static void main(String[] args) {
        final int[][] TABLE = {{1,2,3},{4,5,6},{7,8,9}};


        MagicSquare magicSquare = new MagicSquare();
        magicSquare.couldBeAMagicSquare(TABLE);
        System.out.println(magicSquare.couldBeAMagicSquare(TABLE));
        int[][][] array = magicSquare.getMagicSquareArray(TABLE);
        for (int k = 0; k < array.length; k++) {
            for (int i = 0; i < array[0].length; i++) {
                for (int j = 0; j < array[0][0].length; j++) {
                    System.out.print(array[k][i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }

    }
}
