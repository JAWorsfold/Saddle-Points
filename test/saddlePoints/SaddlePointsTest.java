package saddlepoints;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import saddlePoints.SaddlePoints;

/**
 * @author Joseph Worsfold - jworsfol
 *
 */
public class SaddlePointsTest {
    SaddlePoints sp = new SaddlePoints(); // create an instance variable

    // If you use the same variables in multiple tests,
    //  declare them here

    @Before
    public void setUp() throws Exception {
        int[][] arrayOne = sp.createRandomArray(2, 2, -10, 10);

    }

    @Test
    public void testCreateRandomArrayIsCorrectSize() {
        int[][] arrayOne = sp.createRandomArray(2, 2, -10, 10);
        int[][] arrayTwo = new int[2][2];
        assertTrue(arrayTwo.length == arrayOne.length);
        assertTrue(arrayTwo[0].length == arrayOne[0].length);
    }

    @Test
    public void testCreateRandomArrayIsCorrectRange() {
        int[][] arrayOne = sp.createRandomArray(2, 2, -10, 10);
        for (int i=0; i<arrayOne.length; i++) {
            for (int j=0; j<arrayOne[i].length; j++) {
                assertTrue(arrayOne[i][j] <= 10);
                assertTrue(arrayOne[i][j] >= -10);
            }
        }
    }

    @Test
    public void testCreateRandomArrayDoesNotRepeat() {
        int[][] arrayOne = sp.createRandomArray(2, 2, -10, 10);
        int count = 0;
        int control = arrayOne[0][0];
        for (int i=0; i<arrayOne.length; i++) {
            for (int j = 0; j<arrayOne[i].length; j++) {
                if (control == arrayOne[i][j]) {
                    count++;
                }
            }
        }
        if (count == (arrayOne.length * arrayOne[0].length)) {
            fail("Array should not contain all the same number.");
        }
    }

    @Test
    public void testLargestOne() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals(9, sp.largest(array));
        // Put sp. in front of every call to a method in SaddlePoints
    }

    @Test
    public void testLargestTwo() {
        int[] array = {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 0};
        assertEquals(0, sp.largest(array));
    }

    @Test
    public void testSmallestOne() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals(0, sp.smallest(array));
        // Put sp. in front of every call to a method in SaddlePoints
    }

    @Test
    public void testSmallestTwo() {
        int[] array = {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 0};
        assertEquals(-9, sp.smallest(array));
    }

    @Test
    public void testLargestValuesOne() {
        int[][] array = {{1, 2},{-1, 0}};
        int[] arrayAnswer = {1, 2};
        assertArrayEquals(arrayAnswer, sp.largestValues(array));
    }

    @Test
    public void testLargestValuesTwo() {
        int[][] array = {{1, 2, 3},{-2, 1, 0}};
        int[] arrayAnswer = {1, 2, 3};
        assertArrayEquals(arrayAnswer, sp.largestValues(array));
    }

    @Test
    public void testSmallestValuesOne() {
        int[][] array = {{1, 2}, {-1, 0}};
        int[] arrayAnswer = {1, -1};
        assertArrayEquals(arrayAnswer, sp.smallestValues(array));
    }

    @Test
    public void testSmallestValuesTwo() {
        int[][] array = {{1, 2, 3}, {-2, 1, 0}};
        int[] arrayAnswer = {1, -2};
        assertArrayEquals(arrayAnswer, sp.smallestValues(array));
    }

    @Test
    public void testHasSaddlePointTrue() {
        int[][] array = {{-9, 12, -6},
                         { 7, 14, 5},
                         {10, -8, 3},
                         { 6, 17,-10}};
        assertTrue(sp.hasSaddlePoint(array));
    }

    @Test
    public void testHasSaddlePointFalse() {
        int[][] array = {{ 1, -2, 3},
                         {-6, 5, -4},
                         { 7, -8, 9}};
        assertFalse(sp.hasSaddlePoint(array));
    }
}