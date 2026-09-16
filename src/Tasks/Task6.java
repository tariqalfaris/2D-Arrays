package Tasks;

public class Task6 {

    public static void toDiagonal(int[][] array1) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                if (i != j) {
                    array1[i][j] = 0;
                }
            }
        }
    }


    public static void toLowerTriangular(int[][] array1) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                if (i < j) {
                    array1[i][j] = 0;
                }
            }
        }
    }


    public static void toUpperTriangular(int[][] array1) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                if (i > j) {
                    array1[i][j] = 0;
                }
            }
        }
    }


    public static void printMatrix(int[][] array1) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                System.out.print(array1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[][] diag = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        toDiagonal(diag);
        System.out.println("Diagonal Result:");
        printMatrix(diag);

        int[][] lower = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        toLowerTriangular(lower);
        System.out.println("Lower Triangular Result:");
        printMatrix(lower);

        int[][] upper = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        toUpperTriangular(upper);
        System.out.println("Upper Triangular Result:");
        printMatrix(upper);
    }
}
