package Operations;

public class Tringle {

    public static void toDiagonal(int[][] array1) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                if (i != j) {
                    array1[i][j] = 0;
                }
            }
        }
        printMatrix(array1);
    }


    public static void toLowerTriangular(int[][] array1) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                if (i < j) {
                    array1[i][j] = 0;
                }
            }
        }
        printMatrix(array1);
    }


    public static void toUpperTriangular(int[][] array1) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                if (i > j) {
                    array1[i][j] = 0;
                }
            }
        }
        printMatrix(array1);
    }


    private static void printMatrix(int[][] array1) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                System.out.print(array1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}