
package UnitTesting;

import Tasks.Task6;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Task6Test {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    // Builds the exact text printed: every line ends with a new line
    private String expected(String... lines) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line).append(System.lineSeparator());
        }
        return sb.toString();
    }

    private int[][] sample3x3() {
        return new int[][] { {1,2,3}, {4,5,6}, {7,8,9} };
    }

    // ---------- toDiagonal ----------

    @Test
    void testToDiagonalSquare() {
        int[][] a = sample3x3();
        Task6.toDiagonal(a);
        assertArrayEquals(new int[][] { {1,0,0}, {0,5,0}, {0,0,9} }, a);
    }

    @Test
    void testToDiagonalWideMatrix() {
        int[][] a = { {1,2,3}, {4,5,6} };
        Task6.toDiagonal(a);
        assertArrayEquals(new int[][] { {1,0,0}, {0,5,0} }, a);
    }

    @Test
    void testToDiagonalTallMatrix() {
        int[][] a = { {1,2}, {3,4}, {5,6} };
        Task6.toDiagonal(a);
        assertArrayEquals(new int[][] { {1,0}, {0,4}, {0,0} }, a);
    }

    @Test
    void testToDiagonalKeepsNegativeDiagonal() {
        int[][] a = { {-1,2}, {3,-4} };
        Task6.toDiagonal(a);
        assertArrayEquals(new int[][] { {-1,0}, {0,-4} }, a);
    }

    @Test
    void testToDiagonalAlreadyDiagonalUnchanged() {
        int[][] a = { {1,0}, {0,2} };
        Task6.toDiagonal(a);
        assertArrayEquals(new int[][] { {1,0}, {0,2} }, a);
    }

    @Test
    void testToDiagonalSingleElement() {
        int[][] a = { {7} };
        Task6.toDiagonal(a);
        assertArrayEquals(new int[][] { {7} }, a);
    }

    // ---------- toLowerTriangular ----------

    @Test
    void testToLowerTriangularSquare() {
        int[][] a = sample3x3();
        Task6.toLowerTriangular(a);
        assertArrayEquals(new int[][] { {1,0,0}, {4,5,0}, {7,8,9} }, a);
    }

    @Test
    void testToLowerTriangularWideMatrix() {
        int[][] a = { {1,2,3}, {4,5,6} };
        Task6.toLowerTriangular(a);
        assertArrayEquals(new int[][] { {1,0,0}, {4,5,0} }, a);
    }

    @Test
    void testToLowerTriangularTallMatrix() {
        int[][] a = { {1,2}, {3,4}, {5,6} };
        Task6.toLowerTriangular(a);
        assertArrayEquals(new int[][] { {1,0}, {3,4}, {5,6} }, a);
    }

    @Test
    void testToLowerTriangularNegativeNumbers() {
        int[][] a = { {-1,-2}, {-3,-4} };
        Task6.toLowerTriangular(a);
        assertArrayEquals(new int[][] { {-1,0}, {-3,-4} }, a);
    }

    // ---------- toUpperTriangular ----------

    @Test
    void testToUpperTriangularSquare() {
        int[][] a = sample3x3();
        Task6.toUpperTriangular(a);
        assertArrayEquals(new int[][] { {1,2,3}, {0,5,6}, {0,0,9} }, a);
    }

    @Test
    void testToUpperTriangularWideMatrix() {
        int[][] a = { {1,2,3}, {4,5,6} };
        Task6.toUpperTriangular(a);
        assertArrayEquals(new int[][] { {1,2,3}, {0,5,6} }, a);
    }

    @Test
    void testToUpperTriangularTallMatrix() {
        int[][] a = { {1,2}, {3,4}, {5,6} };
        Task6.toUpperTriangular(a);
        assertArrayEquals(new int[][] { {1,2}, {0,4}, {0,0} }, a);
    }

    @Test
    void testToUpperTriangularNegativeNumbers() {
        int[][] a = { {-1,-2}, {-3,-4} };
        Task6.toUpperTriangular(a);
        assertArrayEquals(new int[][] { {-1,-2}, {0,-4} }, a);
    }

    // ---------- combined behaviour ----------

    @Test
    void testLowerThenUpperGivesDiagonal() {
        int[][] a = sample3x3();
        Task6.toLowerTriangular(a);
        Task6.toUpperTriangular(a);

        int[][] b = sample3x3();
        Task6.toDiagonal(b);

        assertArrayEquals(b, a);
    }

    @Test
    void testCallingTwiceGivesSameResult() {
        int[][] a = sample3x3();
        Task6.toLowerTriangular(a);
        Task6.toLowerTriangular(a);
        assertArrayEquals(new int[][] { {1,0,0}, {4,5,0}, {7,8,9} }, a);
    }

    // ---------- empty and null input ----------

    @Test
    void testEmptyArrayDoesNothing() {
        int[][] a = new int[0][0];
        assertDoesNotThrow(() -> Task6.toDiagonal(a));
        assertDoesNotThrow(() -> Task6.toLowerTriangular(a));
        assertDoesNotThrow(() -> Task6.toUpperTriangular(a));
    }

    @Test
    void testNullArrayThrows() {
        assertThrows(NullPointerException.class, () -> Task6.toDiagonal(null));
        assertThrows(NullPointerException.class, () -> Task6.toLowerTriangular(null));
        assertThrows(NullPointerException.class, () -> Task6.toUpperTriangular(null));
    }

    // ---------- printMatrix ----------

    @Test
    void testPrintMatrix() {
        Task6.printMatrix(new int[][] { {1,2}, {3,4} });
        assertEquals(expected("1 2 ", "3 4 ", ""), outContent.toString());
    }

    @Test
    void testPrintMatrixNegativeNumbers() {
        Task6.printMatrix(new int[][] { {-1,0} });
        assertEquals(expected("-1 0 ", ""), outContent.toString());
    }

    @Test
    void testPrintMatrixEmptyPrintsOnlyBlankLine() {
        Task6.printMatrix(new int[0][0]);
        assertEquals(expected(""), outContent.toString());
    }

    @Test
    void testPrintMatrixNullThrows() {
        assertThrows(NullPointerException.class, () -> Task6.printMatrix(null));
    }

    // ---------- main ----------

    @Test
    void testMainOutput() {
        Task6.main(new String[0]);

        String expectedOutput = expected(
                "Diagonal Result:",
                "1 0 0 ", "0 5 0 ", "0 0 9 ", "",
                "Lower Triangular Result:",
                "1 0 0 ", "4 5 0 ", "7 8 9 ", "",
                "Upper Triangular Result:",
                "1 2 3 ", "0 5 6 ", "0 0 9 ", ""
        );
        assertEquals(expectedOutput, outContent.toString());
    }
}