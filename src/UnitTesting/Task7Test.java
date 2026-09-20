package UnitTesting;

import Tasks.Task7;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Task7Test {

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

    // ---------- submatrix ----------

    @Test
    void testSubmatrixRemoveFirstRowAndColumn() {
        int[][] a = { {1,2,3}, {4,5,6}, {7,8,9} };
        assertArrayEquals(new int[][] { {5,6}, {8,9} }, Task7.submatrix(a, 0, 0));
    }

    @Test
    void testSubmatrixRemoveMiddleRowAndColumn() {
        int[][] a = { {1,2,3}, {4,5,6}, {7,8,9} };
        assertArrayEquals(new int[][] { {1,3}, {7,9} }, Task7.submatrix(a, 1, 1));
    }

    @Test
    void testSubmatrixRemoveLastRowAndColumn() {
        int[][] a = { {1,2,3}, {4,5,6}, {7,8,9} };
        assertArrayEquals(new int[][] { {1,2}, {4,5} }, Task7.submatrix(a, 2, 2));
    }

    @Test
    void testSubmatrixNonSquare() {
        int[][] a = { {1,2,3,4}, {5,6,7,8}, {9,10,11,12} };
        assertArrayEquals(new int[][] { {1,3,4}, {5,7,8} }, Task7.submatrix(a, 2, 1));
    }

    @Test
    void testSubmatrixTwoByTwoGivesOneElement() {
        int[][] a = { {1,2}, {3,4} };
        assertArrayEquals(new int[][] { {4} }, Task7.submatrix(a, 0, 0));
    }

    @Test
    void testSubmatrixNegativeNumbers() {
        int[][] a = { {-1,-2}, {-3,-4} };
        assertArrayEquals(new int[][] { {-3} }, Task7.submatrix(a, 0, 1));
    }

    @Test
    void testSubmatrixSingleElementGivesEmptyMatrix() {
        int[][] result = Task7.submatrix(new int[][] { {5} }, 0, 0);
        assertEquals(0, result.length);
    }

    @Test
    void testSubmatrixReturnsNewArrayAndKeepsInputUnchanged() {
        int[][] a = { {1,2,3}, {4,5,6}, {7,8,9} };

        int[][] result = Task7.submatrix(a, 1, 1);
        result[0][0] = 99;

        assertNotSame(a, result);
        assertArrayEquals(new int[] {1,2,3}, a[0]);
        assertArrayEquals(new int[] {4,5,6}, a[1]);
        assertArrayEquals(new int[] {7,8,9}, a[2]);
    }

    @Test
    void testSubmatrixRowIndexOutOfRangeThrows() {
        int[][] a = { {1,2,3}, {4,5,6}, {7,8,9} };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Task7.submatrix(a, 5, 1));
    }

    @Test
    void testSubmatrixColumnIndexOutOfRangeThrows() {
        int[][] a = { {1,2,3}, {4,5,6}, {7,8,9} };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Task7.submatrix(a, 1, 5));
    }

    @Test
    void testSubmatrixNegativeIndexThrows() {
        int[][] a = { {1,2,3}, {4,5,6}, {7,8,9} };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Task7.submatrix(a, -1, 1));
    }

    @Test
    void testSubmatrixEmptyArrayThrows() {
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> Task7.submatrix(new int[0][0], 0, 0));
    }

    @Test
    void testSubmatrixNullArrayThrows() {
        assertThrows(NullPointerException.class, () -> Task7.submatrix(null, 0, 0));
    }

    // ---------- determinant ----------

    @Test
    void testDeterminantOneByOne() {
        assertEquals(5, Task7.determinant(new int[][] { {5} }));
        assertEquals(-3, Task7.determinant(new int[][] { {-3} }));
    }

    @Test
    void testDeterminantTwoByTwoExample() {
        assertEquals(-14, Task7.determinant(new int[][] { {3,8}, {4,6} }));
    }

    @Test
    void testDeterminantThreeByThreeExample() {
        int[][] a = { {6,1,1}, {4,-2,5}, {2,8,7} };
        assertEquals(-306, Task7.determinant(a));
    }

    @Test
    void testDeterminantThreeByThreeWithNegatives() {
        int[][] a = { {2,-1,3}, {0,4,1}, {5,2,-2} };
        assertEquals(-85, Task7.determinant(a));
    }

    @Test
    void testDeterminantFourByFour() {
        int[][] a = { {1,0,2,-1}, {3,0,0,5}, {2,1,4,-3}, {1,0,5,0} };
        assertEquals(30, Task7.determinant(a));
    }

    @Test
    void testDeterminantFourByFourTridiagonal() {
        int[][] a = { {2,1,0,0}, {1,2,1,0}, {0,1,2,1}, {0,0,1,2} };
        assertEquals(5, Task7.determinant(a));
    }

    @Test
    void testDeterminantIdentityIsOne() {
        int[][] i3 = { {1,0,0}, {0,1,0}, {0,0,1} };
        int[][] i4 = { {1,0,0,0}, {0,1,0,0}, {0,0,1,0}, {0,0,0,1} };
        assertEquals(1, Task7.determinant(i3));
        assertEquals(1, Task7.determinant(i4));
    }

    @Test
    void testDeterminantZeroMatrixIsZero() {
        int[][] a = { {0,0,0}, {0,0,0}, {0,0,0} };
        assertEquals(0, Task7.determinant(a));
    }

    @Test
    void testDeterminantSingularMatrixIsZero() {
        int[][] a = { {1,2,3}, {4,5,6}, {7,8,9} };
        assertEquals(0, Task7.determinant(a));
    }

    @Test
    void testDeterminantDiagonalIsProductOfDiagonal() {
        int[][] a = { {2,0,0}, {0,3,0}, {0,0,4} };
        assertEquals(24, Task7.determinant(a));
    }

    @Test
    void testDeterminantTriangularIsProductOfDiagonal() {
        int[][] a = { {1,2,3}, {0,4,5}, {0,0,6} };
        assertEquals(24, Task7.determinant(a));
    }

    @Test
    void testDeterminantSwappingRowsFlipsSign() {
        assertEquals(-2, Task7.determinant(new int[][] { {1,2}, {3,4} }));
        assertEquals(2, Task7.determinant(new int[][] { {3,4}, {1,2} }));
    }

    @Test
    void testDeterminantOfTransposeIsSame() {
        int[][] a = { {2,-1,3}, {0,4,1}, {5,2,-2} };
        int[][] t = { {2,0,5}, {-1,4,2}, {3,1,-2} };
        assertEquals(Task7.determinant(a), Task7.determinant(t));
    }

    @Test
    void testDeterminantScalingOneRowScalesResult() {
        int[][] a = { {1,2,3}, {4,5,6}, {7,8,10} };
        int[][] scaled = { {1,2,3}, {4,5,6}, {14,16,20} };
        assertEquals(-3, Task7.determinant(a));
        assertEquals(-6, Task7.determinant(scaled));
    }

    @Test
    void testDeterminantDoesNotModifyInput() {
        int[][] a = { {6,1,1}, {4,-2,5}, {2,8,7} };

        Task7.determinant(a);

        assertArrayEquals(new int[] {6,1,1}, a[0]);
        assertArrayEquals(new int[] {4,-2,5}, a[1]);
        assertArrayEquals(new int[] {2,8,7}, a[2]);
    }

    @Test
    void testDeterminantNonSquareThreeByTwoThrows() {
        int[][] a = { {1,2}, {3,4}, {5,6} };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Task7.determinant(a));
    }

    @Test
    void testDeterminantEmptyArrayThrows() {
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> Task7.determinant(new int[0][0]));
    }

    @Test
    void testDeterminantNullArrayThrows() {
        assertThrows(NullPointerException.class, () -> Task7.determinant(null));
    }

    // ---------- main ----------

    @Test
    void testMainOutput() {
        Task7.main(new String[0]);

        String expected = "Determinant (2x2): -14" + System.lineSeparator()
                + "Determinant (3x3): -306" + System.lineSeparator();
        assertEquals(expected, outContent.toString());
    }
}
