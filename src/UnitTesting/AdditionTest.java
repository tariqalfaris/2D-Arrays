package UnitTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static Operations.Addition.matrixAddition;
import static org.junit.jupiter.api.Assertions.*;

public class AdditionTest {

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
    void givenValidInputs_WhenAddition_ThenResultTheMatrixAddition() {
        int[][] a = { {1,2,3,4,5}, {6,7,8,9,10} };
        int[][] b = { {1,2,3,4,5}, {5,4,3,2,1} };

        matrixAddition(a, b);

        String[] expected = {
                "Row 0: 2", "Row 0: 4", "Row 0: 6", "Row 0: 8", "Row 0: 10",
                "Row 1: 11", "Row 1: 11", "Row 1: 11", "Row 1: 11", "Row 1: 11"
        };
        assertArrayEquals(expected, outputLines());
    }

    @Test
    void testSingleElement() {
        matrixAddition(new int[][] { {3} }, new int[][] { {4} });
        assertArrayEquals(new String[] { "Row 0: 7" }, outputLines());
    }

    @Test
    void testZeros() {
        matrixAddition(new int[][] { {0,0}, {0,0} }, new int[][] { {0,0}, {0,0} });
        assertArrayEquals(
                new String[] { "Row 0: 0", "Row 0: 0", "Row 1: 0", "Row 1: 0" },
                outputLines());
    }

    @Test
    void testNegativeNumbers() {
        matrixAddition(new int[][] { {-1,-2}, {5,-5} }, new int[][] { {-3,2}, {-5,5} });
        assertArrayEquals(
                new String[] { "Row 0: -4", "Row 0: 0", "Row 1: 0", "Row 1: 0" },
                outputLines());
    }

    @Test
    void testNonSquareSingleRow() {
        matrixAddition(new int[][] { {1,2,3} }, new int[][] { {10,20,30} });
        assertArrayEquals(
                new String[] { "Row 0: 11", "Row 0: 22", "Row 0: 33" },
                outputLines());
    }

    @Test
    void testSingleColumn() {
        matrixAddition(new int[][] { {1}, {2}, {3} }, new int[][] { {4}, {5}, {6} });
        assertArrayEquals(
                new String[] { "Row 0: 5", "Row 1: 7", "Row 2: 9" },
                outputLines());
    }

    @Test
    void testInputArraysAreNotModified() {
        int[][] a = { {1,2}, {3,4} };
        int[][] b = { {5,6}, {7,8} };

        matrixAddition(a, b);

        assertArrayEquals(new int[] {1,2}, a[0]);
        assertArrayEquals(new int[] {3,4}, a[1]);
        assertArrayEquals(new int[] {5,6}, b[0]);
        assertArrayEquals(new int[] {7,8}, b[1]);
    }

    @Test
    void givenUnequalMatricesSizes_whenAddition_thenThrowException() {
        int[][] a = { {1,2}, {3,4} };
        int[][] b = { {1,2} };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrixAddition(a, b));
    }

    @Test
    void testSecondArrayNarrowerThrows() {
        int[][] a = { {1,2,3} };
        int[][] b = { {1,2} };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrixAddition(a, b));
    }

    @Test
    void testEmptyArrayThrows() {
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> matrixAddition(new int[0][0], new int[0][0]));
    }

    @Test
    void testNullArrayThrows() {
        assertThrows(NullPointerException.class,
                () -> matrixAddition(null, new int[][] { {1} }));
    }

    @Test
    void testMainRuns() {
        int [][] array1={ {1,2,3,4,5},{6,7,8,9,10} };
        int [][] array2={ {1,2,3,4,5},{5,4,3,2,1} };

        matrixAddition(array1,array2);


        assertEquals(10, outputLines().length);
    }
}
