package com.isep.jbmo60927.gameoflife.board;

public class Cell {
    private int state;
    private int livingNeighbors;

    public Cell(int state, int livingNeighbors){
        this.state = state;
        this.livingNeighbors = livingNeighbors;
    }

    /**
     * Given an initial state for the cell, computes its next state
     * @return
     */
    public int nextState(){
        if(this.state == CellState.ALIVE && (this.livingNeighbors == 2 || this.livingNeighbors == 3)) {
            return CellState.ALIVE;
        }

        if(this.state == CellState.DEAD && this.livingNeighbors == 3) {
            return CellState.ALIVE;
        }

        return CellState.DEAD;
    }
}
