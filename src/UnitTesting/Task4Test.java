package UnitTesting;

import Tasks.Task4;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Task4Test {

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

    private String[] outputLines() {
        String text = outContent.toString().trim();
        if (text.isEmpty()) {
            return new String[0];
        }
        return text.split(System.lineSeparator());
    }

    @Test
    void testAssignmentExample() {
        int[][] a = { {1,2,3}, {4,5,6} };
        int[][] b = { {7,8}, {9,10}, {11,12} };

        Task4.matrixMultiplication(a, b);

        String[] expected = { "Row 0: 58", "Row 0: 64", "Row 1: 139", "Row 1: 154" };
        assertArrayEquals(expected, outputLines());
    }

    @Test
    void testSquareMatrices() {
        int[][] a = { {1,2}, {3,4} };
        int[][] b = { {5,6}, {7,8} };

        Task4.matrixMultiplication(a, b);

        assertArrayEquals(
                new String[] { "Row 0: 19", "Row 0: 22", "Row 1: 43", "Row 1: 50" },
                outputLines());
    }

    @Test
    void testIdentityMatrix() {
        int[][] a = { {1,2}, {3,4} };
        int[][] identity = { {1,0}, {0,1} };

        Task4.matrixMultiplication(a, identity);

        assertArrayEquals(
                new String[] { "Row 0: 1", "Row 0: 2", "Row 1: 3", "Row 1: 4" },
                outputLines());
    }

    @Test
    void testZeroMatrix() {
        int[][] a = { {1,2}, {3,4} };
        int[][] zero = { {0,0}, {0,0} };

        Task4.matrixMultiplication(a, zero);

        assertArrayEquals(
                new String[] { "Row 0: 0", "Row 0: 0", "Row 1: 0", "Row 1: 0" },
                outputLines());
    }

    @Test
    void testNegativeNumbers() {
        int[][] a = { {-1,2}, {3,-4} };
        int[][] b = { {2,0}, {1,-1} };

        Task4.matrixMultiplication(a, b);

        assertArrayEquals(
                new String[] { "Row 0: 0", "Row 0: -2", "Row 1: 2", "Row 1: 4" },
                outputLines());
    }

    @Test
    void testSingleElement() {
        Task4.matrixMultiplication(new int[][] { {3} }, new int[][] { {4} });
        assertArrayEquals(new String[] { "Row 0: 12" }, outputLines());
    }

    @Test
    void testRowTimesColumn() {
        int[][] a = { {1,2,3} };
        int[][] b = { {4}, {5}, {6} };

        Task4.matrixMultiplication(a, b);

        assertArrayEquals(new String[] { "Row 0: 32" }, outputLines());
    }

    @Test
    void testColumnTimesRow() {
        int[][] a = { {1}, {2}, {3} };
        int[][] b = { {4,5,6} };

        Task4.matrixMultiplication(a, b);

        assertArrayEquals(
                new String[] {
                        "Row 0: 4", "Row 0: 5", "Row 0: 6",
                        "Row 1: 8", "Row 1: 10", "Row 1: 12",
                        "Row 2: 12", "Row 2: 15", "Row 2: 18"
                },
                outputLines());
    }

    @Test
    void testIncompatibleSizesPrintsMessage() {
        int[][] a = { {1,2}, {3,4} };
        int[][] b = { {1,2}, {3,4}, {5,6} };

        Task4.matrixMultiplication(a, b);

        assertArrayEquals(new String[] { "Cannot multiply" }, outputLines());
    }

    @Test
    void testIncompatibleSizesPrintsNoResultRows() {
        int[][] a = { {1,2,3} };
        int[][] b = { {1,2,3} };

        Task4.matrixMultiplication(a, b);

        assertFalse(outContent.toString().contains("Row"));
    }

    @Test
    void testSecondArrayEmptyPrintsMessage() {
        Task4.matrixMultiplication(new int[][] { {1} }, new int[0][0]);
        assertArrayEquals(new String[] { "Cannot multiply" }, outputLines());
    }

    @Test
    void testInputArraysAreNotModified() {
        int[][] a = { {1,2}, {3,4} };
        int[][] b = { {5,6}, {7,8} };

        Task4.matrixMultiplication(a, b);

        assertArrayEquals(new int[] {1,2}, a[0]);
        assertArrayEquals(new int[] {3,4}, a[1]);
        assertArrayEquals(new int[] {5,6}, b[0]);
        assertArrayEquals(new int[] {7,8}, b[1]);
    }

    @Test
    void testFirstArrayEmptyThrows() {
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> Task4.matrixMultiplication(new int[0][0], new int[][] { {1} }));
    }

    @Test
    void testNullArrayThrows() {
        assertThrows(NullPointerException.class,
                () -> Task4.matrixMultiplication(null, new int[][] { {1} }));
    }

    @Test
    void testMainRuns() {
        Task4.main(new String[0]);
        assertEquals(4, outputLines().length);
    }
}