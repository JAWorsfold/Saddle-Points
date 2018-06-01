Try not to use, so called, *magic numbers*.
```
  int arrayRowSize = 2 + rand.nextInt((5 - 2) + 1);
            int arrayColumnSize = 2 + rand.nextInt((5 - 2) + 1);
            int[][] array = this.createRandomArray(arrayRowSize, arrayColumnSize, 10, 99);
            this.printArray(array);
            this.printArrayInfo(array);
            if (this.hasSaddlePoint(array)) {
                ha
```
Could you have avoided the repeated code structure by utilising an appropriately parameterised *helper* method?

```
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
```
and
```
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

```
