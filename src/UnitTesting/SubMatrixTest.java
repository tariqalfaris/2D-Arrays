package UnitTesting;

import Operations.SubMatrix;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class SubMatrixTest {

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

    // Builds the exact text the method prints: every row ends with a new line
    private String expected(String... rows) {
        StringBuilder sb = new StringBuilder();
        for (String row : rows) {
            sb.append(row).append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Test
    void testAssignmentExample() {
        int[][] a = { {1,2,3,4}, {5,6,7,8}, {9,10,11,12} };

        SubMatrix.submatrix(a, 2, 1);

        assertEquals(expected("1 3 4 ", "5 7 8 "), outContent.toString());
    }

    @Test
    void testRemoveFirstRowAndFirstColumn() {
        int[][] a = { {1,2,3,4}, {5,6,7,8}, {9,10,11,12} };

        SubMatrix.submatrix(a, 0, 0);

        assertEquals(expected("6 7 8 ", "10 11 12 "), outContent.toString());
    }

    @Test
    void testRemoveLastRowAndLastColumn() {
        int[][] a = { {1,2,3}, {4,5,6}, {7,8,9} };

        SubMatrix.submatrix(a, 2, 2);

        assertEquals(expected("1 2 ", "4 5 "), outContent.toString());
    }

    @Test
    void testRemoveMiddleRowAndColumn() {
        int[][] a = { {1,2,3}, {4,5,6}, {7,8,9} };

        SubMatrix.submatrix(a, 1, 1);

        assertEquals(expected("1 3 ", "7 9 "), outContent.toString());
    }

    @Test
    void testNonSquareMatrix() {
        int[][] a = { {1,2,3}, {4,5,6} };

        SubMatrix.submatrix(a, 0, 2);

        assertEquals(expected("4 5 "), outContent.toString());
    }

    @Test
    void testTwoByTwoLeavesOneElement() {
        int[][] a = { {1,2}, {3,4} };

        SubMatrix.submatrix(a, 0, 0);

        assertEquals(expected("4 "), outContent.toString());
    }

    @Test
    void testNegativeNumbers() {
        int[][] a = { {-1,-2}, {-3,-4} };

        SubMatrix.submatrix(a, 0, 1);

        assertEquals(expected("-3 "), outContent.toString());
    }

    @Test
    void testSingleElementMatrixPrintsNothing() {
        SubMatrix.submatrix(new int[][] { {5} }, 0, 0);
        assertEquals("", outContent.toString());
    }

    @Test
    void testSingleRowRemovingItPrintsNothing() {
        SubMatrix.submatrix(new int[][] { {1,2,3} }, 0, 1);
        assertEquals("", outContent.toString());
    }

    @Test
    void testInputArrayIsNotModified() {
        int[][] a = { {1,2,3}, {4,5,6}, {7,8,9} };

        SubMatrix.submatrix(a, 1, 1);

        assertArrayEquals(new int[] {1,2,3}, a[0]);
        assertArrayEquals(new int[] {4,5,6}, a[1]);
        assertArrayEquals(new int[] {7,8,9}, a[2]);
    }

    @Test
    void testRowIndexOutOfRangeThrows() {
        int[][] a = { {1,2,3}, {4,5,6}, {7,8,9} };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> SubMatrix.submatrix(a, 5, 1));
    }

    @Test
    void testColumnIndexOutOfRangeThrows() {
        int[][] a = { {1,2,3}, {4,5,6}, {7,8,9} };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> SubMatrix.submatrix(a, 1, 5));
    }

    @Test
    void testNegativeIndexThrows() {
        int[][] a = { {1,2,3}, {4,5,6}, {7,8,9} };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> SubMatrix.submatrix(a, -1, 1));
    }

    @Test
    void testEmptyArrayThrows() {
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> SubMatrix.submatrix(new int[0][0], 0, 0));
    }

    @Test
    void testNullArrayThrows() {
        assertThrows(NullPointerException.class,
                () -> SubMatrix.submatrix(null, 0, 0));
    }


}
