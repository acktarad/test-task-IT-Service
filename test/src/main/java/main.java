public class main {
    public static void main(String[] args) {
        final int[][] TABLE = {{1,2,3},{4,5,6},{7,8,9}};
        final int[][] TABLE1 = {{2,1,3},{4,5,6},{7,8,9}};


        MagicSquare magicSquare = new MagicSquare();
        magicSquare.couldBeAMagicSquare(TABLE);
        System.out.println(magicSquare.couldBeAMagicSquare(TABLE));
        int[][][] array = magicSquare.getMagicSquareArray(TABLE);
        
    }
}
