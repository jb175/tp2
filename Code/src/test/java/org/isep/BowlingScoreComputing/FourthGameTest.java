package org.isep.BowlingScoreComputing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourthGameTest {

    @Test
    public void testZeroPinByRoll() {
        FourthGame game = new FourthGame();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(0, game.score());
    }

    @Test
    public void testOnePinByRoll() {
        FourthGame game = new FourthGame();
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertEquals(20, game.score());
    }

    @Test
    public void testTenPinsByRoll() {
        FourthGame game = new FourthGame();
        for (int i = 0; i < 12; i++) {
            game.roll(10);
        }
        assertEquals(300, game.score());
    }

    @Test
    public void testTenPinsByTwoRolls() {
        FourthGame game = new FourthGame();
        for (int i = 0; i < 2; i++) {
            game.roll(5);
        }
        for (int j = 2; j < 10; j++) {
            game.roll(1);
        }
        assertEquals(19, game.score());
    }
    
}
