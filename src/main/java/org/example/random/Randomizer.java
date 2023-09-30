package org.example.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomizer {
    private static final Random random = new Random();

    public static int randomPositiveFromInterval(int minVal, int maxVal, List<Integer> blackList) {
        if (minVal > maxVal) {
            int temp = minVal;
            minVal = maxVal;
            maxVal = temp;
        }

        if (maxVal - minVal <= blackList.size() - 1)
            throw new IllegalArgumentException("Impossible to generate num from this interval");

        int randomNum;

        do randomNum = Math.abs(random.nextInt()) % (maxVal - minVal) + minVal;
        while (blackList.contains(randomNum));

        return randomNum;
    }

    public static int randomPositiveFromInterval(int minVal, int maxVal) {
        return randomPositiveFromInterval(minVal, maxVal, new ArrayList<>());
    }
}
