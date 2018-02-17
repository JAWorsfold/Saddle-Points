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
        // If you use the same variables in multiple tests,
        //  assign values to them here
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
    public void testSomeMethod() {
        // Put tests here
        // Put sp. in front of every call to a method in SaddlePoints
    }
}