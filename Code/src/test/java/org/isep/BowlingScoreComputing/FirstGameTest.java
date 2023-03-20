package org.isep.BowlingScoreComputing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FirstGameTest {

    @Test
    public void testZeroPinByRoll() {
        FirstGame game = new FirstGame();
        for (int i = 0; i < 10; i++) {
            game.roll(0);
        }
        assertEquals(0, game.score());
    }

    @Test
    public void testOnePinByRoll() {
        FirstGame game = new FirstGame();
        for (int i = 0; i < 10; i++) {
            game.roll(1);
        }
        assertEquals(10, game.score());
    }

}
