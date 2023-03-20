package com.isep.jbmo60927.gameoflife.error;

public class GameOfLifeException extends Exception {

    public GameOfLifeException() {
        super("Exception occure during the Game Of Life");
    }

    public GameOfLifeException(String message) {
        super("Exception occure during the Game Of Life:\n" + message);
    }
}
