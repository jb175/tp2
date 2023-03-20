package com.isep.jbmo60927.gameoflife;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.isep.jbmo60927.gameoflife.board.Coord;
import com.isep.jbmo60927.gameoflife.board.GameOfLife;
import com.isep.jbmo60927.gameoflife.error.GameOfLifeException;
import com.isep.jbmo60927.gameoflife.logger.MyLogger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static final int ROW_COUNT = 5;
    public static final int COLUMN_COUNT = 5;
    private static final Coord[] INITIAL_ALIVE_CELLS = new Coord[] {
        new Coord(3,2),
        new Coord(3,3),
        new Coord(3,4),
    };

    private static final int NUMBER_OF_GENERATIONS = 5;

    public App() {
        LOGGER.setLevel(Level.INFO);
        try {
            GameOfLife gol = new GameOfLife(ROW_COUNT, COLUMN_COUNT, INITIAL_ALIVE_CELLS);
            gol.computeNthGeneration(NUMBER_OF_GENERATIONS);
        } catch (GameOfLifeException e) {
            LOGGER.log(Level.SEVERE, "error during the game", e);
        }
    }

    public static void main(String[] args) throws IOException {
        MyLogger.setup(); //setup the logger for the app
        new App();
    }
}