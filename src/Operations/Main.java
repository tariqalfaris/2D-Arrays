package Operations;

import Operations.Tringle;

import java.util.Scanner;

import static Operations.Addition.matrixAddition;
import static Operations.MultiplicationByNumbers.matrixMultiplication;
import static Operations.Transpose.transpose;
import static Operations.MatrixMultiplication.matrixMultiplication;
import static Operations.SubMatrix.submatrix;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean keepgoing=true;

        while (keepgoing){

        int numrows1=0;
        int numrows2=0;
        int numcols1=0;
        int numcols2=0;

        int [][] array1;
        int [][] array2;


        System.out.println("Enter the number of the operation you want from the following:");
        System.out.println("1. Add two 2D arrays together");
        System.out.println("2. Multiply a 2D array by a number");
        System.out.println("3. Multiply two 2D arrays together");
        System.out.println("4. Transpose a 2D array");
        System.out.println("5. Get a sub matrix from a 2D array");
        System.out.println("6. Zero out a tringle in a 2D array");
        System.out.println();
        System.out.print("Enter operation number here:");
        int operation = scanner.nextInt();

        System.out.println();
        switch (operation){
            case 1:

                System.out.print("Enter the number of rows for the first array:");
                numrows1=scanner.nextInt();

                System.out.print("Enter the number of columns for the first array:");
                numcols1=scanner.nextInt();

                array1= new int[numrows1][numcols1];
                int temp=0;

                System.out.println("Enter array #1:");

                for(int i=0; i<array1.length; i++) {
                    for (int j = 0; j < array1.length; j++) {
                        System.out.print("Enter element [" + i + "][" +j+ "]:");

                        temp = scanner.nextInt();
                        array1[i][j] = temp;
                    }
                }



                    System.out.println();

                    System.out.print("Enter the number of rows for the second array:");
                    numrows2=scanner.nextInt();

                    System.out.print("Enter the number of columns for the second array:");
                    numcols2=scanner.nextInt();

                    array2= new int[numrows2][numcols2];

                    System.out.println("Enter array 2's elements:");

                    for(int i=0; i<array2.length; i++) {
                        for(int j=0; j<array2.length; j++) {
                            System.out.print("Enter element [" + i + "][" +j+ "]:");

                            temp=scanner.nextInt();
                            array2[i][j]=temp;
                        }

            }

                matrixAddition(array1,array2);
                    break;


                    case 2:

                        System.out.print("Enter the number of rows:");
                        numrows1=scanner.nextInt();

                        System.out.print("Enter the number of columns:");
                        numcols1=scanner.nextInt();

                        array1= new int[numrows1][numcols1];

                         temp=0;

                        System.out.println("Enter array:");

                        for(int i=0; i<array1.length; i++) {
                            for (int j = 0; j < array1.length; j++) {
                                System.out.print("Enter element [" + i + "][" +j+ "]:");

                                temp = scanner.nextInt();
                                array1[i][j] = temp;
                            }
                        }

                        System.out.print("Enter the number you want to multiply the array by:");
                        temp=scanner.nextInt();

                        matrixMultiplication(array1,temp);
                        break;


            case 3:

                System.out.print("Enter the number of rows:");
                numrows1=scanner.nextInt();

                System.out.print("Enter the number of columns:");
                numcols1=scanner.nextInt();

                temp=0;
                array1= new int[numrows1][numcols1];


                System.out.println("Enter array #1:");

                for(int i=0; i<array1.length; i++) {
                    for (int j = 0; j < array1.length; j++) {
                        System.out.print("Enter element [" + i + "][" +j+ "]:");

                        temp = scanner.nextInt();
                        array1[i][j] = temp;
                    }
                }

                System.out.println();

                System.out.print("Enter the number of rows for the second array:");
                numrows2=scanner.nextInt();

                System.out.print("Enter the number of columns for the second array:");
                numcols2=scanner.nextInt();

                array2= new int[numrows2][numcols2];

                System.out.println();
                System.out.println("Enter array #2:");

                for(int i=0; i<array2.length; i++) {
                    for(int j=0; j<array2.length; j++) {
                        System.out.print("Enter element [" + i + "][" +j+ "]:");

                        temp=scanner.nextInt();
                        array2[i][j]=temp;
                    }

                }

                MatrixMultiplication.matrixMultiplication(array1,array2);
                break;



            case 4:
                System.out.print("Enter the number of rows:");
                numrows1=scanner.nextInt();

                System.out.print("Enter the number of columns:");
                numcols1=scanner.nextInt();

                array1= new int[numrows1][numcols1];

                temp=0;

                System.out.println("Enter array:");

                for(int i=0; i<array1.length; i++) {
                    for (int j = 0; j < array1.length; j++) {
                        System.out.print("Enter element [" + i + "][" +j+ "]:");

                        temp = scanner.nextInt();
                        array1[i][j] = temp;
                    }
                }



                transpose(array1);
                break;

            case 5:

                System.out.print("Enter the number of rows:");
                numrows1=scanner.nextInt();

                System.out.print("Enter the number of columns:");
                numcols1=scanner.nextInt();

                array1= new int[numrows1][numcols1];

                temp=0;

                System.out.println("Enter array:");

                for(int i=0; i<array1.length; i++) {
                    for (int j = 0; j < array1.length; j++) {
                        System.out.print("Enter element [" + i + "][" +j+ "]:");

                        temp = scanner.nextInt();
                        array1[i][j] = temp;
                    }
                }

                System.out.print("Enter the number of rows you want to get rid of:");
                int rows=scanner.nextInt();

                System.out.print("Enter the number of columns you want to get rid:");
                int cols=scanner.nextInt();

                submatrix(array1,rows,cols);

                break;

            case 6:

                System.out.println("1. Diagnol triangle:");
                System.out.println("2. Lower triangle");
                System.out.println("3. Upper triangle");
                System.out.print("Enter the number of the operation you want:");
                int op=scanner.nextInt();

                switch(op){

                    case 1:
                        System.out.print("Enter the number of rows:");
                        numrows1=scanner.nextInt();

                        System.out.print("Enter the number of columns:");
                        numcols1=scanner.nextInt();

                        array1= new int[numrows1][numcols1];

                        temp=0;

                        System.out.println("Enter array:");

                        for(int i=0; i<array1.length; i++) {
                            for (int j = 0; j < array1.length; j++) {
                                System.out.print("Enter element [" + i + "][" +j+ "]:");

                                temp = scanner.nextInt();
                                array1[i][j] = temp;
                            }
                        }



                        Tringle.toDiagonal(array1);
                        break;

                    case 2:

                        System.out.print("Enter the number of rows:");
                        numrows1=scanner.nextInt();

                        System.out.print("Enter the number of columns:");
                        numcols1=scanner.nextInt();

                        array1= new int[numrows1][numcols1];

                        temp=0;

                        System.out.println("Enter array:");

                        for(int i=0; i<array1.length; i++) {
                            for (int j = 0; j < array1.length; j++) {
                                System.out.print("Enter element [" + i + "][" +j+ "]:");

                                temp = scanner.nextInt();
                                array1[i][j] = temp;
                            }
                        }



                        Tringle.toLowerTriangular(array1);
                        break;

                    case 3:
                        System.out.print("Enter the number of rows:");
                        numrows1=scanner.nextInt();

                        System.out.print("Enter the number of columns:");
                        numcols1=scanner.nextInt();

                        array1= new int[numrows1][numcols1];

                        temp=0;

                        System.out.println("Enter array:");

                        for(int i=0; i<array1.length; i++) {
                            for (int j = 0; j < array1.length; j++) {
                                System.out.print("Enter element [" + i + "][" +j+ "]:");

                                temp = scanner.nextInt();
                                array1[i][j] = temp;
                            }
                        }



                        Tringle.toUpperTriangular(array1);
                        break;
                }
        }

        System.out.println();
        System.out.print("Would you like to perform another operation? (1 = yes, 0 = no):");
        int again = scanner.nextInt();
        System.out.println();

        if (again != 1) {
            keepgoing = false;
        }
    }

        System.out.println("Goodbye!");



    }
}
