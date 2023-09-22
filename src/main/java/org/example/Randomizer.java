package org.example;

import java.util.Random;

public class Randomizer {
    private static final Random random = new Random();

    public static int randomPositiveFromInterval(int minVal, int maxVal) {
        if (minVal > maxVal) {
            int temp = minVal;
            minVal = maxVal;
            maxVal = temp;
        }

        return Math.abs(random.nextInt()) % maxVal + minVal;
    }
}
