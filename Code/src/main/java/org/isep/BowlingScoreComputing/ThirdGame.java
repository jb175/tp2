package org.isep.BowlingScoreComputing;

public class ThirdGame {

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
            if (rolls[shot] == 10) {
                score += rolls[shot] + rolls[shot + 1] + rolls[shot + 2];
                shot ++;
            } else {
                score += rolls[shot] + rolls[shot + 1];
                shot += 2;
            }
        }
        return score;
    }

}
