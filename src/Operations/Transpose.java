package Operations;

public class Transpose {

    public static void transpose( int[][] array1){

        int [][] finalAnswer= new int[array1[0].length][array1.length];

        for(int i=0; i< array1.length; i++) {
            for (int j=0; j < array1[0].length;j++){

                finalAnswer[j][i]= array1[i][j];

                System.out.println("Row " + i + ": " + finalAnswer[j][i]);
            }
        }
    }
}
