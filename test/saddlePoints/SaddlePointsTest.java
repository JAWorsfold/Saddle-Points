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
    int[][] randomArray;
    int[] arrayLargeSmallOne;
    int[] arrayLargeSmallTwo;
    int[][] arrayLargeSmallValueOne;
    int[][] arrayLargeSmallValueTwo;
    int[][] arrayGameOne;
    int[][] arrayGameTwo;

    int[][] arrayGameThree;
    int[][] arrayGameFour;


    @Before
    public void setUp() {
        randomArray = sp.createRandomArray(2, 2, -10, 10);
        arrayLargeSmallOne = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        arrayLargeSmallTwo = new int[] {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 0};
        arrayLargeSmallValueOne = new int[][] {{1, 2},{-1, 0}};
        arrayLargeSmallValueTwo = new int[][] {{1, 2, 3}, {-2, 1, 0}};
        arrayGameOne = new int[][] {{-9, 12, -6},
                                    { 7, 14,  5},
                                    {10, -8,  3},
                                    { 6, 17,-10}};
        arrayGameTwo = new int[][] {{-50,  29,  17,   4,   8, -15},
                                    { 10,  -3,  45,  28,   2, -44},
                                    { 15,  76,  31, -59,  39, -27},
                                    {  9,  22,  80,  67,  72,   7},
                                    { 33,   1, -13,  18,   2, -53},
                                    {-64,  98,   2, -81,   9,  -1},
                                    {  6,   5,  47, -77,  25,   0}};
        //arrayGameThree = new int[][]
        //arrayGameFour = new int[][]
    }

    @Test
    public void testCreateRandomArrayIsCorrectSize() {
        int[][] arrayTwo = new int[2][2];
        assertTrue(arrayTwo.length == randomArray.length);
        assertTrue(arrayTwo[0].length == randomArray[0].length);
    }

    @Test
    public void testCreateRandomArrayIsCorrectRange() {
        for (int i=0; i<randomArray.length; i++) {
            for (int j=0; j<randomArray[i].length; j++) {
                assertTrue(randomArray[i][j] <= 10);
                assertTrue(randomArray[i][j] >= -10);
            }
        }
    }

    @Test
    public void testCreateRandomArrayDoesNotRepeat() {
        int count = 0;
        int control = randomArray[0][0];
        for (int i=0; i<randomArray.length; i++) {
            for (int j = 0; j<randomArray[i].length; j++) {
                if (control == randomArray[i][j]) {
                    count++;
                }
            }
        }
        if (count == (randomArray.length * randomArray[0].length)) {
            fail("Array should not contain all the same number.");
        }
    }

    @Test
    public void testLargestOne() {
        assertEquals(9, sp.largest(arrayLargeSmallOne));
    }

    @Test
    public void testLargestTwo() {
        assertEquals(0, sp.largest(arrayLargeSmallTwo));
    }

    @Test
    public void testSmallestOne() {
        assertEquals(0, sp.smallest(arrayLargeSmallOne));
    }

    @Test
    public void testSmallestTwo() {
        assertEquals(-9, sp.smallest(arrayLargeSmallTwo));
    }

    @Test
    public void testLargestValuesOne() {
        int[] arrayAnswer = {1, 2};
        assertArrayEquals(arrayAnswer, sp.largestValues(arrayLargeSmallValueOne));
    }

    @Test
    public void testLargestValuesTwo() {
        int[] arrayAnswer = {1, 2, 3};
        assertArrayEquals(arrayAnswer, sp.largestValues(arrayLargeSmallValueTwo));
    }

    @Test
    public void testSmallestValuesOne() {
        int[] arrayAnswer = {1, -1};
        assertArrayEquals(arrayAnswer, sp.smallestValues(arrayLargeSmallValueOne));
    }

    @Test
    public void testSmallestValuesTwo() {
        int[] arrayAnswer = {1, -2};
        assertArrayEquals(arrayAnswer, sp.smallestValues(arrayLargeSmallValueTwo));
    }

    @Test
    public void testHasSaddlePointTrueOne() {
        assertTrue(sp.hasSaddlePoint(arrayGameOne));
    }

    @Test
    public void testHasSaddlePointTrueTwo() {
        assertTrue(sp.hasSaddlePoint(arrayGameTwo));
    }

    @Test
    public void testHasSaddlePointFalseOne() {
        int[][] array = {{ 1, -2, 3},
                         {-6, 5, -4},
                         { 7, -8, 9}};
        assertFalse(sp.hasSaddlePoint(array));
    }

    @Test
    public void testHasSaddlePointFalseTwo() {
        int[][] array = {{-50,  29,  17,   4,   8, -15},
                         { 10,  -3,  45,  28,   2, -44},
                         { 15,  76,  31, -59,  39, -27},
                         {-19,  22,  80,  67,  72,   7},
                         { 33,   1, -13,  18,   2, -53},
                         {-64,  98,   2, -81,   9,  -1},
                         {  6,   5,  47, -77,  25,   0}};
        assertFalse(sp.hasSaddlePoint(array));
    }

    @Test
    public void testSaddlePointRowOne() {
        assertEquals(1, sp.saddlePointRow(arrayGameOne));
    }

    @Test
    public void testSaddlePointRowTwo() {
        assertEquals(3, sp.saddlePointRow(arrayGameTwo));
    }

    @Test
    public void testSaddlePointColumnOne() {
        assertEquals(2, sp.saddlePointColumn(arrayGameOne));
    }

    @Test
    public void testSaddlePointColumnTwo() {
        assertEquals(5, sp.saddlePointColumn(arrayGameTwo));
    }
}