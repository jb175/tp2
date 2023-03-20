package org.isep.BowlingScoreComputing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondGameTest {

    @Test
    public void testZeroPinByRoll() {
        SecondGame game = new SecondGame();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(0, game.score());
    }

    @Test
    public void testOnePinByRoll() {
        SecondGame game = new SecondGame();
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertEquals(20, game.score());
    }

    @Test
    public void testTenPinsByRoll() {
        SecondGame game = new SecondGame();
        for (int i = 0; i < 12; i++) {
            game.roll(10);
        }
        assertEquals(300, game.score());
    }

}
