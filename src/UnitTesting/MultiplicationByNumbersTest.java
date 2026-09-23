package UnitTesting;

import Operations.MultiplicationByNumbers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplicationByNumbersTest {

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
        int[][] a = { {1,2,3,4,5}, {6,7,8,9,10} };

        MultiplicationByNumbers.matrixMultiplication(a, 5);

        String[] expected = {
                "Row 0: 5", "Row 0: 10", "Row 0: 15", "Row 0: 20", "Row 0: 25",
                "Row 1: 30", "Row 1: 35", "Row 1: 40", "Row 1: 45", "Row 1: 50"
        };
        assertArrayEquals(expected, outputLines());
    }

    @Test
    void testMultiplyByZero() {
        MultiplicationByNumbers.matrixMultiplication(new int[][] { {1,2}, {3,4} }, 0);
        assertArrayEquals(
                new String[] { "Row 0: 0", "Row 0: 0", "Row 1: 0", "Row 1: 0" },
                outputLines());
    }

    @Test
    void testMultiplyByOne() {
        MultiplicationByNumbers.matrixMultiplication(new int[][] { {1,2}, {3,4} }, 1);
        assertArrayEquals(
                new String[] { "Row 0: 1", "Row 0: 2", "Row 1: 3", "Row 1: 4" },
                outputLines());
    }

    @Test
    void testNegativeScalar() {
        MultiplicationByNumbers.matrixMultiplication(new int[][] { {1,2}, {3,4} }, -2);
        assertArrayEquals(
                new String[] { "Row 0: -2", "Row 0: -4", "Row 1: -6", "Row 1: -8" },
                outputLines());
    }

    @Test
    void testNegativeElements() {
        MultiplicationByNumbers.matrixMultiplication(new int[][] { {-1,2}, {-3,0} }, 3);
        assertArrayEquals(
                new String[] { "Row 0: -3", "Row 0: 6", "Row 1: -9", "Row 1: 0" },
                outputLines());
    }

    @Test
    void testNegativeElementsAndNegativeScalar() {
        MultiplicationByNumbers.matrixMultiplication(new int[][] { {-1,-2} }, -4);
        assertArrayEquals(
                new String[] { "Row 0: 4", "Row 0: 8" },
                outputLines());
    }

    @Test
    void testSingleElement() {
        MultiplicationByNumbers.matrixMultiplication(new int[][] { {7} }, 6);
        assertArrayEquals(new String[] { "Row 0: 42" }, outputLines());
    }

    @Test
    void testSingleRow() {
        MultiplicationByNumbers.matrixMultiplication(new int[][] { {1,2,3} }, 10);
        assertArrayEquals(
                new String[] { "Row 0: 10", "Row 0: 20", "Row 0: 30" },
                outputLines());
    }

    @Test
    void testSingleColumn() {
        MultiplicationByNumbers.matrixMultiplication(new int[][] { {1}, {2}, {3} }, 4);
        assertArrayEquals(
                new String[] { "Row 0: 4", "Row 1: 8", "Row 2: 12" },
                outputLines());
    }

    @Test
    void testInputArrayIsNotModified() {
        int[][] a = { {1,2}, {3,4} };

        MultiplicationByNumbers.matrixMultiplication(a, 9);

        assertArrayEquals(new int[] {1,2}, a[0]);
        assertArrayEquals(new int[] {3,4}, a[1]);
    }

    @Test
    void testEmptyArrayThrows() {
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> MultiplicationByNumbers.matrixMultiplication(new int[0][0], 2));
    }

    @Test
    void testNullArrayThrows() {
        assertThrows(NullPointerException.class,
                () -> MultiplicationByNumbers.matrixMultiplication(null, 2));
    }


}
