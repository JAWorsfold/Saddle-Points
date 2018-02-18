package saddlePoints;

import saddlePoints.SaddlePoints;

/**
 * @author KLM
 */
public class Main {
    /**
     * @param args Unused.
     */
    public static void main(String[] args) {
        // new SaddlePoints().run();
        SaddlePoints saddle = new SaddlePoints();
        int[][] array = {{-9, 12, -6},
                         { 7, 14,  5},
                         {10, -8,  3},
                         { 6, 17,-10}};
        saddle.printArray(array);
        saddle.printArrayInfo(array);
    }

}
