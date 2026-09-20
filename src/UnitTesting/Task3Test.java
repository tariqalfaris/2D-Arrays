package UnitTesting;

import Tasks.Task3;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {

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

        Task3.transpose(a);

        String[] expected = {
                "Row 0: 1", "Row 0: 2", "Row 0: 3", "Row 0: 4", "Row 0: 5",
                "Row 1: 6", "Row 1: 7", "Row 1: 8", "Row 1: 9", "Row 1: 10"
        };
        assertArrayEquals(expected, outputLines());
    }

    @Test
    void testSingleElement() {
        Task3.transpose(new int[][] { {7} });
        assertArrayEquals(new String[] { "Row 0: 7" }, outputLines());
    }

    @Test
    void testSingleRow() {
        Task3.transpose(new int[][] { {1,2,3} });
        assertArrayEquals(
                new String[] { "Row 0: 1", "Row 0: 2", "Row 0: 3" },
                outputLines());
    }

    @Test
    void testSingleColumn() {
        Task3.transpose(new int[][] { {1}, {2}, {3} });
        assertArrayEquals(
                new String[] { "Row 0: 1", "Row 1: 2", "Row 2: 3" },
                outputLines());
    }

    @Test
    void testSquareMatrix() {
        Task3.transpose(new int[][] { {1,2}, {3,4} });
        assertArrayEquals(
                new String[] { "Row 0: 1", "Row 0: 2", "Row 1: 3", "Row 1: 4" },
                outputLines());
    }

    @Test
    void testNegativeNumbers() {
        Task3.transpose(new int[][] { {-1,-2}, {3,-4} });
        assertArrayEquals(
                new String[] { "Row 0: -1", "Row 0: -2", "Row 1: 3", "Row 1: -4" },
                outputLines());
    }

    @Test
    void testZeros() {
        Task3.transpose(new int[][] { {0,0}, {0,0} });
        assertArrayEquals(
                new String[] { "Row 0: 0", "Row 0: 0", "Row 1: 0", "Row 1: 0" },
                outputLines());
    }

    @Test
    void testInputArrayIsNotModified() {
        int[][] a = { {1,2,3}, {4,5,6} };

        Task3.transpose(a);

        assertArrayEquals(new int[] {1,2,3}, a[0]);
        assertArrayEquals(new int[] {4,5,6}, a[1]);
    }

    @Test
    void testRaggedArrayThrows() {
        int[][] a = { {1,2,3}, {4,5} };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Task3.transpose(a));
    }

    @Test
    void testEmptyArrayThrows() {
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> Task3.transpose(new int[0][0]));
    }

    @Test
    void testNullArrayThrows() {
        assertThrows(NullPointerException.class,
                () -> Task3.transpose(null));
    }

    @Test
    void testMainRuns() {
        Task3.main(new String[0]);
        assertEquals(10, outputLines().length);
    }
}

