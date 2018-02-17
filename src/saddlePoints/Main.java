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
        SaddlePoints sp = new SaddlePoints();
        sp.createRandomArray(4, 4, 0, 9);
    }

}
