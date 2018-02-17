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
        int[][] array = {{10, -2, 3}, {-2, 1, 0}};
        int[] print = saddle.largestValues(array);
        for (int i=0; i<print.length; i++) {
            System.out.print(print[i] + " ");
        }
    }

}
