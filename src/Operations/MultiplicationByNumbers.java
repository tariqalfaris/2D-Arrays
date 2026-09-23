package Operations;

public class MultiplicationByNumbers {

    public static void matrixMultiplication( int[][] array1 , int num){

        int [][] finalAnswer= new int[array1.length][array1[0].length];

        for(int i=0; i< array1.length; i++) {
            for (int j=0; j < array1[0].length;j++){

                finalAnswer[i][j]= num * array1[i][j];

                System.out.println("Row " + i + ": " + finalAnswer[i][j]);
            }
        }
    }
}


