package Operations;

public class SubMatrix {


        public static void submatrix(int[][] array1, int removeRow, int removeCol) {

            int[][] finalAnswer = new int[array1.length - 1][array1[0].length - 1]; //this removes the last coloum

            int newI = 0;

            for (int i = 0; i < array1.length; i++) {

                if (i == removeRow) {
                    continue;
                }


                int newJ = 0;

                for (int j = 0; j < array1[0].length; j++) {

                    if (j == removeCol)
                        continue;


                    finalAnswer[newI][newJ] = array1[i][j];
                    newJ++;
                }

                newI++;
            }


            for (int i = 0; i < finalAnswer.length; i++) {
                for (int j = 0; j < finalAnswer[0].length; j++) {
                    System.out.print(finalAnswer[i][j] + " ");
                }
                System.out.println();
            }
        }
}

