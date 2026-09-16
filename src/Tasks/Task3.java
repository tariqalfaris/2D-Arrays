package Tasks;

public class Task3 {

    public static void transpose( int[][] array1){

        int [][] finalAnswer= new int[array1[0].length][array1.length];

        for(int i=0; i< array1.length; i++) {
            for (int j=0; j < array1[0].length;j++){

                finalAnswer[j][i]= array1[i][j];

                System.out.println("Row " + i + ": " + finalAnswer[j][i]);
            }

        }

    }

    public static void main(String[] args) {

        int [][] array1={ {1,2,3,4,5},{6,7,8,9,10} };



        transpose(array1);





    }

}
