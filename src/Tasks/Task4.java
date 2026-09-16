package Tasks;

public class Task4 {

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

    public static void main(String[] args) {

        int[][] array1 = { {1,2,3}, {4,5,6} };
        int[][] array2 = { {7,8}, {9,10}, {11,12} };

        matrixMultiplication(array1, array2);
    }
}









