package Operations;

public class MatrixMultiplication {

    public static void matrixMultiplication(int[][] array1, int[][] array2) {

        if (array1[0].length != array2.length) {
            System.out.println("Cannot multiply");
            return;
        }

        int[][] finalAnswer = new int[array1.length][array2[0].length];

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2[0].length; j++) {

                int sum = 0;
                for (int k = 0; k < array2.length; k++) {
                    sum += array1[i][k] * array2[k][j];
                }

                finalAnswer[i][j] = sum;

                System.out.println("Row " + i + ": " + finalAnswer[i][j]);
            }
        }
    }
}









