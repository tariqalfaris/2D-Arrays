package Operations;

public class Addition {

    public static void matrixAddition( int[][] array1, int[][] array2){

        int [][] finalAnswer= new int[array1.length][array1[0].length];

        for(int i=0; i< array1.length; i++) {
            for (int j=0; j < array1[0].length;j++){

                finalAnswer[i][j]= array1[i][j] + array2[i][j];

                System.out.println("Row " + i + ": " + finalAnswer[i][j]);
            }

        }

    }

}