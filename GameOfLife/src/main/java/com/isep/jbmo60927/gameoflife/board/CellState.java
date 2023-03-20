package com.isep.jbmo60927.gameoflife.board;

/**
 * This class serves as an enum for the CellState, ether DEAD = 0, or ALIVE = 1
 */
public class CellState {
    public static final int DEAD = 0;
    public static final int ALIVE = 1;
    
    private CellState() {
        throw new IllegalStateException("Utility class");
    }
}
