package org.isep.BowlingScoreComputing;

public class SecondGame {

    private final int[] rolls = new int[21];
    private int current = 0;

    public void roll(int pins) {
        rolls[current] = pins;
        current++;
    }

    public int score() {
        int score = 0;
        int shot = 0;
        for (int frame = 0; frame < 10; frame++) {
            score += rolls[shot] + rolls[shot + 1];
            shot += 2;
        }
        return score;
    }

}
