package saddlePoints;

import java.util.Random;

/**
 * Creates a number of random arrays, and checks each array to see
 * if it contains a saddle point. Prints the arrays and the results.
 *
 * @author Joseph Worsfold - jworsf01
 */
public class SaddlePoints {
    /**
     * Creates arrays various sizes (including some 2x2 arrays and some larger),
     * fills them with random values, and prints each array and information about
     * it. Keeps generating arrays until it has printed at least one with and
     * one without a saddle point.
     */
    void run() {
        Random rand = new Random();
        int hadSaddlePoint = 0;
        int noSaddlePoint = 0;
        do {
            int arrayRowSize = 2 + rand.nextInt((5 - 2) + 1);
            int arrayColumnSize = 2 + rand.nextInt((5 - 2) + 1);
            int[][] array = this.createRandomArray(arrayRowSize, arrayColumnSize, 10, 99);
            this.printArray(array);
            this.printArrayInfo(array);
            if (this.hasSaddlePoint(array)) {
                hadSaddlePoint++;
            } else { noSaddlePoint++; }
        } while ((noSaddlePoint < 1) || (hadSaddlePoint < 1));
    }

    /**
     * Prints the array.
     *
     * @param array The array to be printed.
     */
    void printArray(int[][] array) {
        for (int i=0; i<array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print("| " + array[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    /**
     * Prints whether the given array has a saddle point, and if so, where it is (row and column)
     * and what its value is. (If there are multiple saddle points, just prints the first.)
     *
     * @param array The array to be checked.
     */
    void printArrayInfo(int[][] array) {
        if (this.hasSaddlePoint(array)) {
            System.out.println("The given array has a saddle point at row " + this.saddlePointRow(array)
                    + ", column " + this.saddlePointColumn(array) + ", with the value "
                    + this.largest(this.smallestValues(array)) + ".");
            System.out.println();
        } else {
            System.out.println("This array does not contain a saddle point.");
            System.out.println();
        }
    }

    /**
     * Creates and returns an array of the given size and fills it with random
     * values in the specified range.
     *
     * @param numberOfRows    The number of rows desired.
     * @param numberOfColumns The number of columns desired.
     * @param minValue        The smallest number allowable in the array.
     * @param maxValue        The largest number allowable in the array.
     * @return
     */
    public int[][] createRandomArray(int numberOfRows, int numberOfColumns, int minValue, int maxValue) {
        Random rand = new Random();
        int[][] array = new int[numberOfRows][numberOfColumns];
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array[i].length; j++) {
                array[i][j] = minValue + rand.nextInt((maxValue - minValue) + 1);
            }
        }
        return array;
    }

    /**
     * Finds the largest value in an array of integers.
     *
     * @param array The array to be searched.
     * @return The largest value in the array.
     */
    public int largest(int[] array) {
        int largest = array[0];
        for (int i=0; i<array.length; i++) {
            if (largest < array[i]){ largest = array[i]; }
        }
        return largest;
    }

    /**
     * Finds the smallest value in an array of integers.
     *
     * @param array The array to be searched.
     * @return The smallest value in the array.
     */
    public int smallest(int[] array) {
        int smallest = array[0];
        for (int i=0; i<array.length; i++) {
            if (smallest > array[i]){ smallest = array[i]; }
        }
        return smallest;
    }

    /**
     * Returns an array containing the largest values in each column of the given array.
     *
     * @param array The array to be searched.
     * @return An array of the largest values in each column.
     */
    public int[] largestValues(int[][] array) {
        int[] largestValues = new int[array[0].length];
        for (int i=0; i<array[0].length; i++) {
            int largest = array[0][i];
            for (int j=0; j<array.length; j++) {
                if (array[j][i] > largest) { largest = array[j][i]; }
            }
        largestValues[i] = largest;
        }
        return largestValues;
    }

    /**
     * Returns an array containing the smallest values in each row of the given array.
     *
     * @param array The array to be searched.
     * @return An array of the smallest values in each row.
     */
    public int[] smallestValues(int[][] array) {
        int[] smallestValues = new int[array.length];
        for (int i=0; i<array.length; i++) {
            int smallest = array[i][0];
            for (int j=0; j<array[i].length; j++) {
                if (array[i][j] < smallest) { smallest = array[i][j]; }
            }
            smallestValues[i] = smallest;
        }
        return smallestValues;
    }


    /**
     * Returns true if the given array has a saddle point, and false if it does not.
     *
     * @param array The array to be checked.
     * @return True if the array has a saddle point, else false.
     */
    public boolean hasSaddlePoint(int[][] array) {
        // compare the largest of the smallest values against the smallest of the largest values using methods
        return this.largest(this.smallestValues(array)) == this.smallest(this.largestValues(array));
    }

    /**
     * Given an array that is known to have a saddle point, returns the number of a
     * row containing a saddle point. If more than one row contains a saddle point,
     * the first such row will be returned.
     *
     * @param array An array containing one or more saddle points.
     * @return The lowest-numbered row containing a saddle point.
     */
    public int saddlePointRow(int[][] array) {
        int position = 0;
        for (int i = 0; i<array.length; i++) {
            for (int j = 0; j<array[0].length; j++) {
                if (array[i][j] == this.largest(this.smallestValues(array))) {
                    position = i;
                }
            }
        }
        return position;
    }

    /**
     * Given an array that is known to have a saddle point, returns the number of a
     * column containing a saddle point. If more than one column contains a saddle point,
     * the first such column will be returned.
     *
     * @param array An array containing one or more saddle points.
     * @return The lowest-numbered column containing a saddle point.
     */

    public int saddlePointColumn(int[][] array) {
        int position = 0;
        for (int i = 0; i<array.length; i++) {
            for (int j = 0; j<array[0].length; j++) {
                if (array[i][j] == this.smallest(this.largestValues(array))) {
                    position = j;
                }
            }
        }
        return position;
    }
}