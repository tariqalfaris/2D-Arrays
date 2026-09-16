package Tasks;

public class Task7 {

    public static int[][] submatrix(int[][] array1, int removeRow, int removeCol) {

        int[][] finalAnswer = new int[array1.length - 1][array1[0].length - 1];

        int newI = 0;

        for (int i = 0; i < array1.length; i++) {

            if (i == removeRow) {
                continue;
            }

            int newJ = 0;

            for (int j = 0; j < array1[0].length; j++) {

                if (j == removeCol) {
                    continue;
                }

                finalAnswer[newI][newJ] = array1[i][j];
                newJ++;
            }

            newI++;
        }

        return finalAnswer;
    }

    public static int determinant(int[][] array1) {


        if (array1.length == 1) {
            return array1[0][0];
        }


        if (array1.length == 2) {
            return (array1[0][0] * array1[1][1]) - (array1[0][1] * array1[1][0]);
        }


        int result = 0;
        int sign = 1;

        for (int j = 0; j < array1[0].length; j++) {

            int[][] smallerMatrix = submatrix(array1, 0, j);

            result += sign * array1[0][j] * determinant(smallerMatrix);

            sign = sign * -1;
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix2x2 = {
                {3, 8},
                {4, 6}
        };
        System.out.println("Determinant (2x2): " + determinant(matrix2x2));

        int[][] matrix3x3 = {
                {6, 1, 1},
                {4, -2, 5},
                {2, 8, 7}
        };
        System.out.println("Determinant (3x3): " + determinant(matrix3x3));
    }
}
