public class Task1 {

    public static void matrixAddition( int[][] array1, int[][] array2){

        int [][] finalAnswer= new int[array1.length][array1[0].length];

        for(int i=0; i< array1.length; i++) {
            for (int j=0; j < array1[0].length;j++){

                finalAnswer[i][j]= array1[i][j] + array2[i][j];

                System.out.println("Row " + i + ": " + finalAnswer[i][j]);
            }

        }

    }

    public static void main(String[] args) {

        int [][] array1={ {1,2,3,4,5},{6,7,8,9,10} };
        int [][] array2={ {1,2,3,4,5},{5,4,3,2,1} };

        matrixAddition(array1,array2);





    }


}