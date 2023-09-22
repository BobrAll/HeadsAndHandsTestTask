package org.example;

public class Dice {
    private static final int MIN_DICE_VALUE = 1;
    private static final int MAX_DICE_VALUE = 6;

    public static int roll() {
        return Randomizer.randomPositiveFromInterval(MIN_DICE_VALUE, MAX_DICE_VALUE);
    }
}
